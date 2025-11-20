package com.felipemovio.TransacaoSimples.mappers;

import com.felipemovio.TransacaoSimples.DTO.response.CarteiraResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.TransacaoResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.UsuarioResumoDTO;
import com.felipemovio.TransacaoSimples.entity.Carteira;
import com.felipemovio.TransacaoSimples.entity.Transacoes;

public class CarteiraMapper {
    public static CarteiraResponseDTO toDTO(Carteira c){

        UsuarioResumoDTO usuarioDTO = new UsuarioResumoDTO(
                c.getUsuario().getId(),
                c.getUsuario().getNomeCompleto(),
                c.getUsuario().getEmail()
        );
        return new CarteiraResponseDTO(
                c.getId(),
                c.getSaldo(),
                usuarioDTO
        );
    }
}
