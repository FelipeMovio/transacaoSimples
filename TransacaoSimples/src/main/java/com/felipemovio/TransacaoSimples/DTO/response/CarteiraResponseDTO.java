package com.felipemovio.TransacaoSimples.DTO.response;

import java.math.BigDecimal;

public record CarteiraResponseDTO(
        Long id,
        BigDecimal saldo,
        UsuarioResumoDTO usuario
) {
}
