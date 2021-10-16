package com.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ciclo3.reto3.model.UAdmin;
import com.ciclo3.reto3.repository.UAdminRepository;


@Service
public class UAdminService {
	
	@Autowired
	private UAdminRepository uAminAdminRepository;
	
	public List<UAdmin> getAll(){
		return uAminAdminRepository.getAll();
	}
	
	public Optional<UAdmin> getUAdmin(int id){
		return uAminAdminRepository.getUAdmin(id);
	}
	
	public UAdmin save(UAdmin uAdmin) {
		if(uAdmin.getIdUAdmin()==null) {
			return uAminAdminRepository.save(uAdmin);
		}else {
			Optional<UAdmin> uAdminOptional=uAminAdminRepository.getUAdmin(uAdmin.getIdUAdmin());
			if(uAdminOptional.isEmpty()) {
				return uAminAdminRepository.save(uAdmin);
			}else {
				return uAdmin;
			}
		}
	}
}
