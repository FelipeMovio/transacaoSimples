package com.felipemovio.TransacaoSimples.controller.adm;

import com.felipemovio.TransacaoSimples.DTO.response.CarteiraResponseDTO;
import com.felipemovio.TransacaoSimples.DTO.response.TransacoesResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Carteira;
import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.mappers.CarteiraMapper;
import com.felipemovio.TransacaoSimples.mappers.TransacaoMapper;
import com.felipemovio.TransacaoSimples.services.CarteiraService;
import com.felipemovio.TransacaoSimples.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdmController {

    @Autowired
    private CarteiraService carteiraService;

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping("/cartels")
    public ResponseEntity<List<CarteiraResponseDTO>> verTodas(){
        List<Carteira> c1 = carteiraService.verTodasCarteiras();
        List<CarteiraResponseDTO> response = CarteiraMapper.toDTO(c1);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransacoesResponseDTO>> verAll(){
        List<Transacoes> t1 = transacoesService.verTodas();
        List<TransacoesResponseDTO> response = TransacaoMapper.toDTO(t1);
        return ResponseEntity.ok(response);
    }
}
