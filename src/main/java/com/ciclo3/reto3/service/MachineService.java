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
	
	public Machine update(Machine machine) {
		if(machine.getId()!=null) {
			Optional<Machine> e=machineRepository.getMachine(machine.getId());
			if(!e.isEmpty()) {
				if(machine.getName()!=null) {
					e.get().setName(machine.getName());
				}
				if(machine.getBrand()!=null) {
					e.get().setBrand(machine.getBrand());
				}
				if(machine.getYear()!=null) {
					e.get().setYear(machine.getYear());
				}
				if(machine.getDescription()!=null) {
					e.get().setDescription(machine.getDescription());
				}
				if(machine.getCategory()!=null) {
					e.get().setCategory(machine.getCategory());
				}
				if(machine.getMessages()!=null) {
					e.get().setMessages(machine.getMessages());
				}
				if(machine.getReservations()!=null) {
					e.get().setReservations(machine.getReservations());
				}
				machineRepository.save(e.get());
				return e.get();
			}else {
				return machine;
			}
		}else {
			return machine;
		}
	}
	
	public boolean delete(int id) {
		Boolean bool = getMachine(id).map(machine -> {
			machineRepository.delete(machine);
			return true;
		}).orElse(false);
		return bool;
	}
}
