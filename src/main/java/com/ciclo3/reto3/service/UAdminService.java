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
	private UAdminRepository uAdminRepository;
	
	public List<UAdmin> getAll(){
		return uAdminRepository.getAll();
	}
	
	public Optional<UAdmin> getUAdmin(int id){
		return uAdminRepository.getUAdmin(id);
	}
	
	public UAdmin save(UAdmin uAdmin) {
		if(uAdmin.getIdUAdmin()==null) {
			return uAdminRepository.save(uAdmin);
		}else {
			Optional<UAdmin> uAdminOptional=uAdminRepository.getUAdmin(uAdmin.getIdUAdmin());
			if(uAdminOptional.isEmpty()) {
				return uAdminRepository.save(uAdmin);
			}else {
				return uAdmin;
			}
		}
	}
	
	public UAdmin update(UAdmin uAdmin) {
		if(uAdmin.getIdUAdmin()!=null) {
			Optional<UAdmin> e=uAdminRepository.getUAdmin(uAdmin.getIdUAdmin());
			if(!e.isEmpty()) {
				if(uAdmin.getName()!=null) {
					e.get().setName(uAdmin.getName());
				}
				if(uAdmin.getEmail()!=null) {
					e.get().setEmail(uAdmin.getEmail());
				}
				if(uAdmin.getPassword()!=null) {
					e.get().setPassword(uAdmin.getPassword());
				}
				uAdminRepository.save(e.get());
				return e.get();
			}else {
				return uAdmin;
			}
		}else {
			return uAdmin;
		}	
	}
		
	public boolean delete(int id) {
		Boolean bool = getUAdmin(id).map(uAdmin -> {
			uAdminRepository.delete(uAdmin);
			return true;
		}).orElse(false);
		return bool;
	}
}
