package com.technoplus.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.technoplus.cursomc.domain.Categoria;
import com.technoplus.cursomc.dto.CategoriaDTO;
import com.technoplus.cursomc.repositories.CategoriaRepository;
import com.technoplus.cursomc.services.exceptions.DataIntegrityException;
import com.technoplus.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.List;
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
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return  repo.findAll(pageRequest);
		
	}
	
	//tratamento de erro instanciar objecto categoria e passar dados 
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
		
	}
	
	
	
	
}
 