package com.ciclo3.reto3.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ciclo3.reto3.model.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer>{
	
}
