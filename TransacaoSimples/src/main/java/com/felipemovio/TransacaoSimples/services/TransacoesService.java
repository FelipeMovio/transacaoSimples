package com.felipemovio.TransacaoSimples.services;

import com.felipemovio.TransacaoSimples.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;
}
