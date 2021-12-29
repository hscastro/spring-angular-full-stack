package com.hscastro.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hscastro.entities.Cliente;
import com.hscastro.service.ClienteService;


@RestController
@RequestMapping(value = "/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(clienteService.save(cliente));
	}
	
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable("id") Long id) {
		return clienteService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));		
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		return ResponseEntity.ok(clienteService.findAll());
	}
}
