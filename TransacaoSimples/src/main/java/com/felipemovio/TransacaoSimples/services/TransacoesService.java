package com.felipemovio.TransacaoSimples.services;

import com.felipemovio.TransacaoSimples.entity.Transacoes;
import com.felipemovio.TransacaoSimples.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;

    public List<Transacoes> verTodas(){
        return transacoesRepository.findAll();
    }

    // ver Todas por ID
    public List<Transacoes> verTodasById(Long id){
        return transacoesRepository.findAllByPagadorId(id);
    }

}
