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
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Fulano da Silva");
			cliente1.setCpf("72827263620");
			repo.save(cliente1);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Beltrano de Oliveira");
			cliente2.setCpf("84834234245");
			repo.save(cliente2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiClientesApplication.class, args);
	}

}
