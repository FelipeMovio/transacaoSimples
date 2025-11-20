package com.felipemovio.TransacaoSimples.mappers;

import com.felipemovio.TransacaoSimples.DTO.response.CarteiraResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.UsuarioResumoDTO;
import com.felipemovio.TransacaoSimples.entity.Carteira;

import java.util.List;

public class CarteiraMapper {

    // Converter um único objeto
    public static CarteiraResponseDTO toDTO(Carteira c) {
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

    // Converter uma lista
    public static List<CarteiraResponseDTO> toDTO(List<Carteira> carteiras) {
        return carteiras.stream()
                .map(CarteiraMapper::toDTO)
                .toList();
    }
}
