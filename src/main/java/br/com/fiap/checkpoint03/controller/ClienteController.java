package br.com.fiap.checkpoint03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.checkpoint03.model.Cliente;

@Controller
public class ClienteController {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/home/newCliente")	
	public String cadastroCliente() {
		return "cadastroCliente";
	}
	
	@GetMapping("/clientes")	
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("clientes");
		String sql = "select * from tb_cliente";
		List<Cliente> clientes = jdbcTemplate.query(sql, 
											BeanPropertyRowMapper.newInstance(Cliente.class));
		modelAndView.addObject("clientes", clientes);
		return modelAndView;
	}
	
	
	
	
	int id = 0;
	@PostMapping("/clientes") 
	 public String save(Cliente cliente) {
		 try {
			 cliente.setId(id++) ;
			 String sql = "insert into tb_cliente (id, nome, endereco, tipo, documento, dt_nascimento) "
			 		+ "values ( " + cliente.id + ", '" + cliente.nome + "', '" + cliente.endereco + "', '" + cliente.tipo + "', '" + cliente.documento + "', '" + cliente.dt_nascimento + "')";
			 jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
			 

		 }catch(Exception exception) {}
		 return "clientes"; 	 
	 }
	 
}
