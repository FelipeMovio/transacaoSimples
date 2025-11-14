package com.felipemovio.TransacaoSimples.services;

import com.felipemovio.TransacaoSimples.DTO.request.RegisterRequestDTO;
import com.felipemovio.TransacaoSimples.DTO.response.RegisterResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Role;
import com.felipemovio.TransacaoSimples.entity.Usuario;
import com.felipemovio.TransacaoSimples.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        Role role;
        if (dto.getRole() != null) {
            role = dto.getRole();
        } else {
            role = Role.ROLE_USER;
        }


        Usuario newUser = Usuario.builder()
                .nomeCompleto(dto.getNomeCompleto())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .roles(Set.of(role))
                .build();

        Usuario saved = usuarioRepository.save(newUser);

        return new RegisterResponseDTO(saved.getId(), saved.getNomeCompleto(), saved.getEmail());
    }
}
