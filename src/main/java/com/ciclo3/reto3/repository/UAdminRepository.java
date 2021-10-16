package com.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclo3.reto3.model.UAdmin;
import com.ciclo3.reto3.repository.crud.UAdminCrudRepository;

@Repository
public class UAdminRepository {
	
	@Autowired
	private UAdminCrudRepository uAdminCrudRepository;
	
	public List<UAdmin> getAll(){
		return (List<UAdmin>)uAdminCrudRepository.findAll();
	}
	
	public Optional<UAdmin> getUAdmin(int id){
		return uAdminCrudRepository.findById(id);
	}
	
	public UAdmin save(UAdmin uAdmin) {
		return uAdminCrudRepository.save(uAdmin);
	}

}
