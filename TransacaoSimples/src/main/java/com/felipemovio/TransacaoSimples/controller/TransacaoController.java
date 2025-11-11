package com.felipemovio.TransacaoSimples.controller;

import com.felipemovio.TransacaoSimples.DTO.TransacaoDTO;
import com.felipemovio.TransacaoSimples.services.TransferenciasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransacaoController {

    private final TransferenciasService transferenciasService;

    @PostMapping
    public ResponseEntity<Void> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO){
        transferenciasService.transferirValores(transacaoDTO);
        return ResponseEntity.accepted().build();
    }

}
