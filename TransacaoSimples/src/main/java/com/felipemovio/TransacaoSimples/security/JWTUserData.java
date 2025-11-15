package com.felipemovio.TransacaoSimples.security;

import lombok.Builder;

import java.util.List;

// informações que terao no token
@Builder
public record JWTUserData(Long userId, String email, List<String> tipoUsuario ,List<String> roles) {
}
