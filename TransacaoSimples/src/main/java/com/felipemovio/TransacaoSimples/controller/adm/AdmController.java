package com.felipemovio.TransacaoSimples.controller.adm;

import com.felipemovio.TransacaoSimples.entity.Carteira;
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
    public ResponseEntity<List<Carteira>> verTodas(){
        List<Carteira> c1 = carteiraService.verTodasCarteiras();
        return ResponseEntity.ok(c1);
    }
}
