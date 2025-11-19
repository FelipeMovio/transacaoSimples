package com.felipemovio.TransacaoSimples.DTO.response;

import com.felipemovio.TransacaoSimples.entity.Carteira;
import com.felipemovio.TransacaoSimples.entity.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserRecebedorTransacoesResponseDTO {

    private Long id;

    private String nomeCompleto;

    private TipoUsuario tipoUsuario;

}
