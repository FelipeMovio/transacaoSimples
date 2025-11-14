package com.felipemovio.TransacaoSimples.DTO.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterResponseDTO {
    private Long id;
    private String nomeCompleto;
    private String email;
}
