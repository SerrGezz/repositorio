package com.ciclo3.reto3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.reto3.model.Client;
import com.ciclo3.reto3.service.ClientService;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/all")
	public List<Client> getClient(){
		return clientService.viewAll();
	}
	
	@PostMapping("/save")
	public void PostClient(@RequestBody Client client) {
		clientService.save(client);		
	}
	
	@PutMapping("/update")
	public void putClient(@RequestBody Client client) {
		clientService.update(client);
	}
	
	@DeleteMapping("/delete/{idClient}")
	public void deleteClient(@PathVariable("idClient") Integer id) {
		clientService.delete(id);
	}

}
