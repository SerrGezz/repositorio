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

import com.ciclo3.reto3.model.Machine;
import com.ciclo3.reto3.service.MachineService;

@RestController
@RequestMapping("api/Machine")
public class MachineController {
	@Autowired
	private MachineService machineService;
	
	@GetMapping("/all")
	public List<Machine> getMachine(){
		return machineService.viewAll();
	}
	
	@PostMapping("/save")
	public void postMachine(@RequestBody Machine machine) {
		machineService.save(machine);
	}
	
	@PutMapping("/update")
	public void putMachine(@RequestBody Machine machine) {
		machineService.update(machine);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMachine(@PathVariable("id") Integer id) {
		machineService.delete(id);
	}
}
