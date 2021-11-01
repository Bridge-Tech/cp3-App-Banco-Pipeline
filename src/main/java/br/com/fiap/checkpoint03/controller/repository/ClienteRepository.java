package br.com.fiap.checkpoint03.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.checkpoint03.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
