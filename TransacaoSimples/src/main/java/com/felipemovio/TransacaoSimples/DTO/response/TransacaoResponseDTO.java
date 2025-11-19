package com.felipemovio.TransacaoSimples.DTO.response;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoResponseDTO(
        Long id,
        BigDecimal valor,
        UsuarioResumoDTO pagador,
        UsuarioResumoDTO recebedor,
        LocalDateTime dataHora
) {
}
