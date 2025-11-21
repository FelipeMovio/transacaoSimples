package com.felipemovio.TransacaoSimples.services;

import com.felipemovio.TransacaoSimples.DTO.response.RegisterResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.repository.UsuarioRepository;
import com.felipemovio.TransacaoSimples.security.JWTUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario buscarPorUsuario(Long id){
        return repository.findById(id).orElseThrow( () -> new RuntimeException("Usuário não encontrado") );
    }

    // ver minha conta
    public Usuario verConta(){
        JWTUserData userData = getAuthenticatedUserData();
        return repository.findById(userData.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    // Recupera dados do usuário autenticado via JWT
    private JWTUserData getAuthenticatedUserData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof JWTUserData userData) {
            return userData;
        }
        throw new RuntimeException("Usuário não autenticado");
    }
}
