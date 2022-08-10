package com.technoplus.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoplus.cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepository extends  JpaRepository<Pagamento, Integer> {

}

//nao precisa criar repository das sub-class
