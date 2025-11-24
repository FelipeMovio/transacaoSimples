package com.felipemovio.TransacaoSimples.controller.users;

import com.felipemovio.TransacaoSimples.DTO.response.UsuarioDetalhesDTO;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.mappers.UsuarioMapper;
import com.felipemovio.TransacaoSimples.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/me")
    public ResponseEntity<UsuarioDetalhesDTO> verUserLogado() {
        Usuario u = usuarioService.verConta();

        UsuarioDetalhesDTO response = UsuarioMapper.toDTO(u);


        return ResponseEntity.ok(response);
    }

}
