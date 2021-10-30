package br.com.fiap.checkpoint03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

	@RequestMapping("/novoCliente")	
	public String cadastroCliente() {
		return "cadastroCliente";
	}
}
