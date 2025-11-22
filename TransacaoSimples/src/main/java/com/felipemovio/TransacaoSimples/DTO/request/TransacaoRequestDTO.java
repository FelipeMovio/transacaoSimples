package com.felipemovio.TransacaoSimples.DTO.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
                                            // payer = pagador
                                            // payee = recebedor
public record TransacaoRequestDTO(
     @NotNull BigDecimal value,
     @NotNull Long payer,
     @NotNull Long payee) {
}
