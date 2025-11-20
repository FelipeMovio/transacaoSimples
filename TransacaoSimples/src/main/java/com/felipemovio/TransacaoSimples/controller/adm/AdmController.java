package com.felipemovio.TransacaoSimples.controller.adm;

import com.felipemovio.TransacaoSimples.DTO.response.CarteiraResponseDTO;
import com.felipemovio.TransacaoSimples.entity.Carteira;
import com.felipemovio.TransacaoSimples.mappers.CarteiraMapper;
import com.felipemovio.TransacaoSimples.services.CarteiraService;
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

    @GetMapping("/carteiras")
    public ResponseEntity<List<CarteiraResponseDTO>> verTodas(){
        List<Carteira> c1 = carteiraService.verTodasCarteiras();
        List<CarteiraResponseDTO> response = CarteiraMapper.toDTO(c1);
        return ResponseEntity.ok(response);
    }
}
