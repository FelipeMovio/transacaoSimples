package com.felipemovio.TransacaoSimples.mappers;

import com.felipemovio.TransacaoSimples.DTO.response.UsuarioDetalhesResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Usuario;

import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDetalhesResponseDTO toDTO(Usuario u) {
        return new UsuarioDetalhesResponseDTO(
                u.getId(),
                u.getNomeCompleto(),
                u.getEmail(),
                u.getRoles().stream().map(Enum::name).collect(Collectors.toSet()),
                u.getTipoUsuario().stream().map(Enum::name).collect(Collectors.toSet())
        );
    }
}
