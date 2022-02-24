package com.hscastro.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hscastro.entities.Cliente;
import com.hscastro.service.ClienteService;


@RestController
@RequestMapping(value = "/api/clientes")
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

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable("id") Long id, @RequestBody @Valid Cliente cliente) {
		clienteService.update(id, cliente);		
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
}
