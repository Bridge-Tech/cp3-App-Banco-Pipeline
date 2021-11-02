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

import br.com.fiap.checkpoint03.model.Conta;

@Controller
public class ContaController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/home")	
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		String sql = "select * from tb_conta";
		List<Conta> contas = jdbcTemplate.query(sql, 
											BeanPropertyRowMapper.newInstance(Conta.class));
;
		modelAndView.addObject("contas", contas);
		return modelAndView;
	}
	
	@RequestMapping("/home/new")	
	public String create() {
		return "cadastroConta";
	}
	
	int id = 0;
	 @PostMapping("/home") 
	 public String save(Conta conta) {
		try {
		 	id++; 
		 	conta.setId(id);
			 String sql = "insert into tb_conta (id, agencia, numero, vl_saldo, dt_abertura, cliente) "
			 		+ "values ( " + conta.id + ", " + conta.agencia + ", " + conta.numero + ", " + conta.saldo + ", '" + conta.dt_abertura + "', '" + conta.cliente + "')";
			 jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Conta.class));
			 System.out.println(conta);
		}catch(Exception exception) {}
		 return "index"; 	 
	 }
	 
	 
	
}
