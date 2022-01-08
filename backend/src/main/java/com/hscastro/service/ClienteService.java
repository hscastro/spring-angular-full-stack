package com.hscastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.hscastro.entities.Cliente;
import com.hscastro.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente update(Long id, Cliente clienteUpdate) {
		return clienteRepository
			.findById(id)
			.map(cliente -> {
				 cliente.setNome(clienteUpdate.getNome());
				 cliente.setCpf(clienteUpdate.getCpf());
				 return clienteRepository.save(cliente);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
	
	public void delete(Long id) {
		clienteRepository
			.findById(id)
			.map(cliente -> {
				 clienteRepository.delete(cliente);
				 return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
}
