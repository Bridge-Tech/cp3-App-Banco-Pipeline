package br.com.fiap.checkpoint03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.checkpoint03.controller.repository.ClienteRepository;
import br.com.fiap.checkpoint03.model.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;

	@RequestMapping("/home/newCliente")	
	public String cadastroCliente() {
		return "cadastroCliente";
	}
	
	@GetMapping("/clientes")	
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("clientes");
		List<Cliente> clientes = repository.findAll();
		modelAndView.addObject("clientes", clientes);
		return modelAndView;
	}
	
	
	@PostMapping("/clientes") 
	 public String save(Cliente cliente) {
		 repository.save(cliente);
		 System.out.println(cliente); 
		 return "index"; 	 
	 }
}
