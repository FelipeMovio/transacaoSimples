package com.felipemovio.TransacaoSimples.services;


import com.felipemovio.TransacaoSimples.DTO.request.TransacaoRequestDTO;
import com.felipemovio.TransacaoSimples.entity.TipoUsuario;
import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.repository.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferenciasService {

    private final UsuarioService usuarioService;
    private final CarteiraService carteiraService;
    private final TransacoesRepository transacoesRepository;

    @Transactional
    public Transacoes transferirValores(TransacaoRequestDTO transacaoRequestDTO) {
        // Lógica de transferência de valores entre contas

        // Buscar o usuário pagador e recebedor no banco de dados
        Usuario pagador = usuarioService.buscarPorUsuario(transacaoRequestDTO.payer());
        Usuario recebedor = usuarioService.buscarPorUsuario(transacaoRequestDTO.payee());

        // nao pode se auto mandar dinheiro
        if (transacaoRequestDTO.payer().equals(transacaoRequestDTO.payee())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é permitido transferir para si mesmo.");
        }


        // Validar se o pagador é um usuário comum
        validarPagador(pagador);
        // Validar se o pagador tem saldo suficiente
        validarSaldoUsuario(pagador, transacaoRequestDTO.value());

        // Atualizar o saldo do pagador , subtract = subtrair
        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoRequestDTO.value()));
        carteiraService.salvar(pagador.getCarteira());

        // Atualizar o saldo do recebedor , add = adicionar
        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoRequestDTO.value()));
        carteiraService.salvar(recebedor.getCarteira());

        // Registrar a transação no banco de dados
        Transacoes transacoes = Transacoes.builder()
                .valor(transacaoRequestDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();
        return transacoesRepository.save(transacoes);


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
        if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente para realizar a transferência.");
        }
    }



}
