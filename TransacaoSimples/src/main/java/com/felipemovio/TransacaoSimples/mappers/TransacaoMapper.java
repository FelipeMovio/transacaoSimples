package com.felipemovio.TransacaoSimples.mappers;

import com.felipemovio.TransacaoSimples.DTO.response.TransacaoResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.UsuarioResumoDTO;
import com.felipemovio.TransacaoSimples.entity.Transacoes;


public class TransacaoMapper {

    public static TransacaoResponseDTO toDTO(Transacoes t) {

        UsuarioResumoDTO pagador = new UsuarioResumoDTO(
                t.getPagador().getId(),
                t.getPagador().getNomeCompleto(),
                t.getPagador().getEmail()
        );

        UsuarioResumoDTO recebedor = new UsuarioResumoDTO(
                t.getRecebedor().getId(),
                t.getRecebedor().getNomeCompleto(),
                t.getRecebedor().getEmail()
        );

        return new TransacaoResponseDTO(
                t.getId(),
                t.getValor(),
                pagador,
                recebedor,
                t.getDataHoraTransacao()
        );
    }
}
