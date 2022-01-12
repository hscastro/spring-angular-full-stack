package com.hscastro.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.hscastro.dto.ServicoPrestadoDTO;
import com.hscastro.entities.Cliente;
import com.hscastro.entities.ServicoPrestado;
import com.hscastro.repositories.ClienteRepository;
import com.hscastro.repositories.ServicoPrestadoRepository;
import com.hscastro.util.BigDecimalConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/api/service-prestado")
@CrossOrigin("http://localhost:4200")
public class ServicoPrestadoResource {

	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BigDecimalConverter bigDecimalConverter; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado createService(@RequestBody ServicoPrestadoDTO dto) {

		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Long idCliente = dto.getIdCliente();

		Cliente cliente = clienteRepository
		.findById(idCliente)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente!"));

		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		servicoPrestado.setData(data);
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}	
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
		@RequestParam(value = "nome", required = false) String nome,
		@RequestParam(value = "mes", required = false) Integer mes ) {

		return servicoPrestadoRepository.findByNameClienteAndMes("%"+ nome +"%", mes);
	}
	
	public Optional<ServicoPrestado> findById(Long id) {
		return servicoPrestadoRepository.findById(id);
	}

	public ServicoPrestado updateService(Long id, ServicoPrestado servicoPrestadoUpdate) {
		return servicoPrestadoRepository
			.findById(id)
			.map(servicoPrestado -> {
				servicoPrestado.setDescricao(servicoPrestadoUpdate.getDescricao());
				servicoPrestado.setCliente(servicoPrestadoUpdate.getCliente());
				servicoPrestado.setValor(servicoPrestadoUpdate.getValor());
				 return servicoPrestadoRepository.save(servicoPrestado);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado!"));
	}
	
	public void deleteService(Long id) {
		servicoPrestadoRepository
			.findById(id)
			.map(servicoPrestado -> {
				servicoPrestadoRepository.delete(servicoPrestado);
				 return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado!"));
	}

	public List<ServicoPrestado> findAllService() {
		return servicoPrestadoRepository.findAll();
	}
}
