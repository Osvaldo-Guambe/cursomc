package com.technoplus.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoplus.cursomc.domain.Categoria;
import com.technoplus.cursomc.repositories.CategoriaRepository;
import com.technoplus.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecto não encontrado! id:"+id+", tipo: "+Categoria.class.getName()));
		
	}
	
}
 