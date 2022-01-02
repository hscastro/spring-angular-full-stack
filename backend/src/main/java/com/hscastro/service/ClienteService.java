package com.hscastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
}
