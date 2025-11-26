package com.felipemovio.TransacaoSimples.mappers;

import com.felipemovio.TransacaoSimples.DTO.response.TransacoesResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.UsuarioResumoResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Transacoes;

import java.util.List;


public class TransacaoMapper {

    public static TransacoesResponseDTO toDTO(Transacoes t) {

        UsuarioResumoResponseDTO pagador = new UsuarioResumoResponseDTO(
                t.getPagador().getId(),
                t.getPagador().getNomeCompleto(),
                t.getPagador().getEmail()
        );

        UsuarioResumoResponseDTO recebedor = new UsuarioResumoResponseDTO(
                t.getRecebedor().getId(),
                t.getRecebedor().getNomeCompleto(),
                t.getRecebedor().getEmail()
        );

        return new TransacoesResponseDTO(
                t.getId(),
                t.getValor(),
                pagador,
                recebedor,
                t.getDataHoraTransacao()
        );
    }
    public static List<TransacoesResponseDTO> toDTO(List<Transacoes> transacoes) {
        return transacoes.stream()
                .map(TransacaoMapper::toDTO)
                .toList();
    }
}
