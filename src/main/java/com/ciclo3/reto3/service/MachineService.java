package com.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Machine;
import com.ciclo3.reto3.repository.MachineRepository;


@Service
public class MachineService {
	
	@Autowired
	private MachineRepository machineRepository;
	
	public List<Machine> getAll(){
		return machineRepository.getAll();
	}
	
	public Optional<Machine> getMachine(int id){
		return machineRepository.getMachine(id);
	}
	
	public Machine save(Machine machine) {
		if(machine.getId()==null) {
			return machineRepository.save(machine);
		}else {
			Optional<Machine> machineOptional=machineRepository.getMachine(machine.getId());
			if(machineOptional.isEmpty()) {
				return machineRepository.save(machine);
			}else {
				return machine;
			}
		}
	}
}
