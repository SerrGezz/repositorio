package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Client;
import com.ciclo3.reto3.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	public void update(Client client) {
		clientRepository.save(client);
	}
	
	public void delete(Integer id) {
		clientRepository.deleteById(id);;
	}
	
	public List<Client> viewAll(){
		return clientRepository.findAll();
}
}
