package com.technoplus.cursomc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technoplus.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepositoryValidation extends CrudRepository<Categoria,Long> {

}
