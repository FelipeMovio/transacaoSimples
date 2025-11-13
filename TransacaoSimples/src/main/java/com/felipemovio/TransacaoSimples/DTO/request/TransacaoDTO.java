package com.felipemovio.TransacaoSimples.DTO.request;

import java.math.BigDecimal;
                                            // payer = pagador
                                            // payee = recebedor
public record TransacaoDTO(BigDecimal value, Long payer, Long payee) {
}
