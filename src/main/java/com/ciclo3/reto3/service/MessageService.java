package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Message;
import com.ciclo3.reto3.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	public void save(Message message) {
		messageRepository.save(message);
	}
	
	public void update(Message message) {
		messageRepository.save(message);
	}
	
	public void delete(Integer id) {
		messageRepository.deleteById(id);
	}
	
	public List<Message> viewAll(){
		return messageRepository.findAll();
}
}
