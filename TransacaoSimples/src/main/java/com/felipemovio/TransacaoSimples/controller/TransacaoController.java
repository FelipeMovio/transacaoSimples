package com.felipemovio.TransacaoSimples.controller;

import com.felipemovio.TransacaoSimples.DTO.request.TransacaoRequestDTO;
import com.felipemovio.TransacaoSimples.DTO.response.TransacoesResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.mappers.TransacaoMapper;
import com.felipemovio.TransacaoSimples.services.TransferenciasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransacaoController {

    @Autowired
    private TransferenciasService transferenciasService;

    @PostMapping
    public ResponseEntity<TransacoesResponseDTO> realizarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        Transacoes transacoes = transferenciasService.transferirValores(transacaoRequestDTO);
        TransacoesResponseDTO response = TransacaoMapper.toDTO(transacoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
