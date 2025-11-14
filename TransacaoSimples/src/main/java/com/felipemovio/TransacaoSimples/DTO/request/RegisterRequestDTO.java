package com.felipemovio.TransacaoSimples.DTO.request;

import com.felipemovio.TransacaoSimples.entity.Role;
import com.felipemovio.TransacaoSimples.entity.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private String senha;


    private TipoUsuario tipoUsuario;

    private Role role;
}
