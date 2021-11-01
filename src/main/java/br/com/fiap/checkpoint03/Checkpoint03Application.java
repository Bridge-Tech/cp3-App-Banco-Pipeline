package br.com.fiap.checkpoint03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.checkpoint03.model.Conta;

@SpringBootApplication
public class Checkpoint03Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Checkpoint03Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "select * from tb_conta";
		List<Conta> contas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Conta.class));
		System.out.println(contas);
	}

}
