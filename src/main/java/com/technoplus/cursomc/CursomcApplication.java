package com.technoplus.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.technoplus.cursomc.domain.Categoria;
import com.technoplus.cursomc.domain.Producto;
import com.technoplus.cursomc.repositories.CategoriaRepository;
import com.technoplus.cursomc.repositories.ProdutoRespository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRespository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Producto p1 = new Producto(null, "Cumputador",2000.00);
		Producto p2 = new Producto(null, "Mesa", 300.00);
		Producto p3 = new Producto(null, "Mouse", 200.00);
		
		
		cat1.getProductos().addAll(Arrays.asList(p1,p3));
		cat2.getProductos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//salvar repository responsavel por irmos buscar os dados 
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
 