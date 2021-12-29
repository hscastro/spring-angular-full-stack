package com.hscastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hscastro.entities.Cliente;
import com.hscastro.repositories.ClienteRepository;

@SpringBootApplication
public class ApiClientesApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repo) {
		return args -> {
			
			Cliente cliente = new Cliente();
			cliente.setNome("Fulano");
			cliente.setCpf("00000000000");
			repo.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiClientesApplication.class, args);
	}

}
