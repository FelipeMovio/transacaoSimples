package com.felipemovio.TransacaoSimples.controller.users;

import com.felipemovio.TransacaoSimples.DTO.response.TransacoesResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.UsuarioDetalhesDTO;
import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.mappers.TransacaoMapper;
import com.felipemovio.TransacaoSimples.mappers.UsuarioMapper;
import com.felipemovio.TransacaoSimples.services.TransacoesService;
import com.felipemovio.TransacaoSimples.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping("/me")
    public ResponseEntity<UsuarioDetalhesDTO> verUserLogado() {
        Usuario u = usuarioService.verConta();
        UsuarioDetalhesDTO response = UsuarioMapper.toDTO(u);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transfer/pagador/{id}")
    public ResponseEntity<List<TransacoesResponseDTO>> verTodasTransacoesDoUserPagador(@PathVariable Long id){
       List <Transacoes> transacoes = transacoesService.verTodasPagadorById(id);
       List <TransacoesResponseDTO> response = TransacaoMapper.toDTO(transacoes);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }


}
