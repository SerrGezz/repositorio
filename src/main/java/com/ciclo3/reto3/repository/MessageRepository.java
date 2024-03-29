package com.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Message;
import com.ciclo3.reto3.repository.crud.MessageCrudRepository;

@Service
public class MessageRepository {
	
	@Autowired
	private MessageCrudRepository messageCrudRepository;
	
	public List<Message> getAll(){
		return (List<Message>)messageCrudRepository.findAll();
	}
	
	public Optional<Message> getMessage(int id){
		return messageCrudRepository.findById(id);
	}
	
	public Message save(Message message) {
		return messageCrudRepository.save(message);
	}
	
	public void delete(Message message) {
		messageCrudRepository.delete(message);
	}
}
