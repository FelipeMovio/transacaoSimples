package com.felipemovio.TransacaoSimples.controller;

import com.felipemovio.TransacaoSimples.DTO.request.RegisterRequestDTO;
import com.felipemovio.TransacaoSimples.DTO.response.RegisterResponseDTO;
import com.felipemovio.TransacaoSimples.security.TokenConfig;
import com.felipemovio.TransacaoSimples.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO dto){
        RegisterResponseDTO user = authService.register(dto);
        return ResponseEntity.ok(user);
    }

}
