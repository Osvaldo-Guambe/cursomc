package com.technoplus.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technoplus.cursomc.domain.Cliente;
import com.technoplus.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> lista(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
				
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

}
