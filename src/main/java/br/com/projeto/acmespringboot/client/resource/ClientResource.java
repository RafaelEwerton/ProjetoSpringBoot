package br.com.projeto.acmespringboot.client.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projeto.acmespringboot.client.domain.Client;
import br.com.projeto.acmespringboot.client.repository.ClientRepository;

/**
 * 
 * @author Rafael Ewerton
 *
 */

@RestController
@RequestMapping("/api/clients")
public class ClientResource {
	
	//inserindo injection para se comunicar com o resource
	
	@Autowired
	private ClientRepository repository;
	
	//get solicitação, verbo http de leitura
	//put verbo, metodo do HTTP, realiza alterações na base de dados
	//post envia dados para o banco de dados
	//Delete deleta dados.
	
	
	@PutMapping
	public void updateCliente(@RequestBody Client client, @RequestParam("id") Long id) throws Exception {
		this.repository.findById(id).orElseThrow (() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Client not found"));
		
		this.repository.save(client);
		
		//modelMapper
		//DTO  - Padrão de projeto para facilitar a comunicação entre o cliente e o servidor
		//Status de retorno
		
		
		
		
		
	}
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		 return this.repository.findById(id).get();
			
	}
	
	@DeleteMapping("/{id}")
	public void deleteClien(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}
	
	@GetMapping
	public List<Client> getAllClients(){
		List<Client> clients = this.repository.findAll();
		return clients;
	}
	
	@PostMapping
	public void createClient(@RequestBody Client client) {
		this.repository.save(client);
	}
	
	

}
