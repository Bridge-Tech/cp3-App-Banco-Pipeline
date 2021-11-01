package br.com.fiap.checkpoint03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.checkpoint03.controller.repository.ContaRepository;
import br.com.fiap.checkpoint03.model.Conta;

@Controller
public class ContaController {
	
	@Autowired
	private ContaRepository repository;
	
	@GetMapping("/home")	
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Conta> contas = repository.findAll();
		modelAndView.addObject("contas", contas);
		return modelAndView;
	}
	
	@RequestMapping("/home/new")	
	public String create() {
		return "cadastroConta";
	}
	
	
	 @PostMapping("/home") 
	 public String save(Conta conta) {
		 repository.save(conta);
		 System.out.println(conta); 
		 return "index"; 	 
	 }
	
}
