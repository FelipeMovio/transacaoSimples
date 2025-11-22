package com.felipemovio.TransacaoSimples.DTO.response;

import java.util.Set;

public record UsuarioDetalhesDTO(
        Long id,
        String nomeCompleto,
        String email,
        Set<String> roles,
        Set<String> tipoUsuario
) {
}
