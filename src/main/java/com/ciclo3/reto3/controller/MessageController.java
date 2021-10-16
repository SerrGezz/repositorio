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

import com.ciclo3.reto3.model.Message;
import com.ciclo3.reto3.service.MessageService;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/all")
	public List<Message> getMessage(){
		return messageService.viewAll();
	}
	
	@PostMapping("/save")
	public void postMessage(@RequestBody Message message) {
	messageService.save(message);
	}
	
	@PutMapping("/update")
	public void putMessage(@RequestBody Message message) {
		messageService.update(message);
	}
	
	@DeleteMapping("/delete/{idMessage}")
	public void deleteMessage(@PathVariable("idMessage") Integer id) {
		messageService.delete(id);
	}
}
