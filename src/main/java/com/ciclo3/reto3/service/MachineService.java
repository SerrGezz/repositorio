package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ciclo3.reto3.model.Machine;
import com.ciclo3.reto3.repository.MachineRepository;

@Service
public class MachineService {
	
	@Autowired
	private MachineRepository machineRepository;
	
	public void save(Machine machine) {
		machineRepository.save(machine);
	}
	
	public void update(Machine machine) {
		machineRepository.save(machine);
	}
	
	public void delete(Integer id) {
		machineRepository.deleteById(id);
	}

	public List<Machine> viewAll(){
		return machineRepository.findAll();
}
}
