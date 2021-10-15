package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.UAdmin;
import com.ciclo3.reto3.repository.UAdminRepository;

@Service
public class UAdminService {
	
	@Autowired
	private UAdminRepository uAminAdminRepository;
	
	public void save(UAdmin uAdmin) {
		uAminAdminRepository.save(uAdmin);
	}

	public void update(UAdmin uAdmin){
		uAminAdminRepository.save(uAdmin);
	}
	
	public void delete(Integer id) {
		uAminAdminRepository.deleteById(id);
	}
	
	public List<UAdmin> viewAll(){
		return uAminAdminRepository.findAll();
	}
}
