package com.felipemovio.TransacaoSimples.DTO.response;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacoesResponseDTO(
        Long id,
        BigDecimal valor,
        UsuarioResumoResponseDTO pagador,
        UsuarioResumoResponseDTO recebedor,
        LocalDateTime dataHora
) {
}
