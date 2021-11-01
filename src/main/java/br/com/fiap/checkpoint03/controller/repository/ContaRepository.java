package br.com.fiap.checkpoint03.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.checkpoint03.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
