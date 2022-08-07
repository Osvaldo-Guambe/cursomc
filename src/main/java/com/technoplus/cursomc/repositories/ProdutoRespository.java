package com.technoplus.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoplus.cursomc.domain.Producto;

@Repository
public interface ProdutoRespository extends JpaRepository<Producto, Integer> {

}
