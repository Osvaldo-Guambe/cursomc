package com.technoplus.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.technoplus.cursomc.domain.Categoria;
import com.technoplus.cursomc.repositories.CategoriaRepository;
import com.technoplus.cursomc.services.exceptions.DataIntegrityException;
import com.technoplus.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecto não encontrado! id:"+id+", tipo: "+Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {
		//objecto novo a ser insiro tem que ser null por isso dedinimos 
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
	    find(obj.getId());
		return repo.save(obj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que tem produtos");
		}
		
		
	}
	
	
	
	
}
 