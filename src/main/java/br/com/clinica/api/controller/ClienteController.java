package br.com.clinica.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.clinica.api.dto.ClienteDto;
import br.com.clinica.api.model.Cliente;
import br.com.clinica.api.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	//GET, POST,PUT, DELETE e PATCH
	//CRUD = CREATE,READ,UPDATE e DELETE
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public ResponseEntity<?> listarTodos(){
		var pesquisarCliente = clienteRepository.findAll();
		
		if(pesquisarCliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado !");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid ClienteDto clienteDto){
		var pesquisarCliente = clienteRepository.findByCpf(clienteDto.cpf());
		
		if(pesquisarCliente != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente já existe em nosso sistema !");
		}
		
		var cliente = new Cliente();
		
		BeanUtils.copyProperties(clienteDto, cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarIdCliente(@PathVariable("id") Long idCliente){
		var pesquisarCliente = clienteRepository.findById(idCliente).orElse(null);
		
		if(pesquisarCliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado !");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findById(idCliente));
	}
	
	@PatchMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long idCliente, @RequestBody ClienteDto clienteDto){
		var clientePesquisar = clienteRepository.findById(idCliente).orElse(null);
		
		if(clientePesquisar == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado !");
		}
		
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		
		cliente.setNome(cliente.getNome());
		cliente.setSobrenome(cliente.getSobrenome());
		cliente.setDataNasc(cliente.getDataNasc());
		cliente.setCpf(cliente.getCpf());
		cliente.setTelefone(cliente.getTelefone());
		cliente.setEmail(cliente.getEmail());
		cliente.setIdCliente(idCliente);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteRepository.save(cliente));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long idCliente){
		var clientePesquisar = clienteRepository.findById(idCliente).orElse(null);
		
		if(clientePesquisar == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado !");
		}
		
		this.clienteRepository.delete(clientePesquisar);
		
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso !");
		
	}
}
