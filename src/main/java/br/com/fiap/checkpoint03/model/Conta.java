package br.com.fiap.checkpoint03.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Conta {
	
	@Id 
	public int id;
	
	public int agencia;
	
	public int numero;
	
	public Long saldo;
	
	public String dt_abertura;
	
	public String cliente;
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	public String getAbertura() {
		return dt_abertura;
	}
	public void setAbertura(String data) {
		this.dt_abertura = data;
	}
	
	
	
	 public Conta(String cliente, int numero, int agencia, Long saldo, String data) { 
		 super(); 
		 this.numero = numero; 
		 this.agencia = agencia; 
		 this.cliente = cliente; 
		 this.dt_abertura = data; 
		 this.saldo = saldo; 
		 }
	 
	
	public Conta() {}

}
