package com.ciclo3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.reto3.model.Machine;
import com.ciclo3.reto3.service.MachineService;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MachineController {
	@Autowired
	private MachineService machineService;

	
	@GetMapping("/all")
	public List<Machine> getMachine(){
		return machineService.getAll();
	}
		
	@GetMapping("/{id}")
	public Optional<Machine> getMachine1(@PathVariable("id") int id){
		return machineService.getMachine(id);
	}
		
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Machine postCategory(@RequestBody Machine machine) {
		return machineService.save(machine);
	}
	
}
