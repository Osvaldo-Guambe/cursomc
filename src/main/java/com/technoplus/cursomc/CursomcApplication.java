package com.technoplus.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.technoplus.cursomc.domain.Categoria;
import com.technoplus.cursomc.domain.Cidade;
import com.technoplus.cursomc.domain.Cliente;
import com.technoplus.cursomc.domain.Endereco;
import com.technoplus.cursomc.domain.Estado;
import com.technoplus.cursomc.domain.Pagamento;
import com.technoplus.cursomc.domain.PagamentoBoleto;
import com.technoplus.cursomc.domain.PagamentoComCartao;
import com.technoplus.cursomc.domain.Pedido;
import com.technoplus.cursomc.domain.Producto;
import com.technoplus.cursomc.domain.enums.EstadoPagamento;
import com.technoplus.cursomc.domain.enums.TipoCliente;
import com.technoplus.cursomc.repositories.CategoriaRepository;
import com.technoplus.cursomc.repositories.CidadeRepository;
import com.technoplus.cursomc.repositories.ClienteRepository;
import com.technoplus.cursomc.repositories.EnderecoRepository;
import com.technoplus.cursomc.repositories.EstadoRepository;
import com.technoplus.cursomc.repositories.PagamentoRepository;
import com.technoplus.cursomc.repositories.PedidoRepository;
import com.technoplus.cursomc.repositories.ProdutoRespository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRespository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired 
	private ClienteRepository clienteRepository;
	@Autowired 
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	

	
	
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
		
		
		Estado est1 = new Estado(null,"Maputo");
		Estado est2 = new Estado(null,"Gaza");
		
		Cidade c1 = new Cidade(null,"matola",est1);
		Cidade c2 = new Cidade(null,"magoanine",est1);
		Cidade c3 = new Cidade(null,"macia",est2);
		Cidade c4 = new Cidade(null,"Chokwe",est2);
		
	   est1.getCidades().addAll(Arrays.asList(c1,c2));
	   est2.getCidades().addAll(Arrays.asList(c3,c4));
		
		//salvar repository responsavel por irmos buscar os dados 
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Cliente cl1 = new Cliente(null,"osvaldo guambe","osvaldofilipeguambe@gmail.com","122333444433",TipoCliente.PESSOAFISICA);
		
		cl1.getTelefones().addAll(Arrays.asList("842529182","842529183"));
		
		Endereco en1 = new Endereco(null,"Av. 24 de Julho","300","300","Jardim","553534534",cl1,c1);
		Endereco en2 = new Endereco(null,"Av. 25 de Setembro","300","300","33nadar","553534534",cl1,c2);
		
		cl1.getEnderecos().addAll(Arrays.asList(en1,en2));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(en1, en2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:00"), cl1,en1,null);
		Pedido ped2 = new Pedido(null,sdf.parse("30/09/2018 10:00"), cl1,en2, null);
		
		/*Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1,6);
		ped1.setPagamento(pagto1);
		
	    Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("20/10/2017 00:00"),null);
		ped1.setPagamento(pagto2);*/
		
		cl1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
	    pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		//pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));  
	    
	    
		
		
		
		
		
		
	}

}
 