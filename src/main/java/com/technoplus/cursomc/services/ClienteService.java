package com.technoplus.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoplus.cursomc.domain.Cliente;
import com.technoplus.cursomc.repositories.ClienteRepository;
import com.technoplus.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecato nao encontradoo"));
	} 	

}
