package com.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclo3.reto3.model.Machine;
import com.ciclo3.reto3.repository.crud.MachineCrudRepository;

@Repository
public class MachineRepository {
	
	@Autowired
	private MachineCrudRepository machineCrudRepository;
	
	public List<Machine> getAll(){
		return (List<Machine>)machineCrudRepository.findAll();
	}
	
	public Optional<Machine> getMachine(int id){
		return machineCrudRepository.findById(id);
	}
	
	public Machine save(Machine machine) {
		return machineCrudRepository.save(machine);
	} 
	
	public void delete(Machine machine) {
		machineCrudRepository.delete(machine);
	}
}
