package com.felipemovio.TransacaoSimples.repository;

import com.felipemovio.TransacaoSimples.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
    List<Transacoes>  findAllByPagadorId(Long id);
}
