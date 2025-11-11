package com.felipemovio.TransacaoSimples.services;


import com.felipemovio.TransacaoSimples.DTO.TransacaoDTO;
import com.felipemovio.TransacaoSimples.entity.TipoUsuario;
import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.repository.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferenciasService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final CarteiraService carteiraService;
    private final TransacoesRepository transacoesRepository;

    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO) {
        // Lógica de transferência de valores entre contas

        // Buscar o usuário pagador e recebedor no banco de dados
        Usuario pagador = usuarioService.buscarPorUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarPorUsuario(transacaoDTO.payee());

        // Validar se o pagador é um usuário comum
        validarPagador(pagador);
        // Validar se o pagador tem saldo suficiente
        validarSaldoUsuario(pagador, transacaoDTO.value());
        // Validar a transação com a API externa
        validarTransferencia();

        // Atualizar o saldo do pagador , subtract = subtrair
        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));
        carteiraService.salvar(pagador.getCarteira());

        // Atualizar o saldo do recebedor , add = adicionar
        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoDTO.value()));
        carteiraService.salvar(recebedor.getCarteira());

        // Registrar a transação no banco de dados
        Transacoes transacoes = Transacoes.builder()
                .valor(transacaoDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();
        transacoesRepository.save(transacoes);

    }

    //validar se nosso pagador nao é um lojista
    private void validarPagador(Usuario usuario) {
        if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
            throw new IllegalArgumentException("Lojistas não podem realizar transferências.");
        } else if (usuario.getTipoUsuario().equals(TipoUsuario.COMUN)) {
            return;
        }
    }

    // validar saldo usuario
    private void validarSaldoUsuario(Usuario usuario, BigDecimal valor) {

        try {
            if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Saldo insuficiente para realizar a transferência.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    // validar transação
    private void validarTransferencia() {
        boolean autorizado = autorizacaoService.validarTransacao();
        if (autorizado) {
            System.out.println("Transação aceita");
        } else {
            throw new IllegalArgumentException("Transação não autorizada");
        }

    }

}
