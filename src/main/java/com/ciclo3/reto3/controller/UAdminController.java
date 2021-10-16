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

import com.ciclo3.reto3.model.UAdmin;
import com.ciclo3.reto3.service.UAdminService;

@RestController
@RequestMapping("/api/UAdmin")
public class UAdminController {

	@Autowired
	private UAdminService uAdminService;
	
	@GetMapping("/all")
	public List<UAdmin> getUAdmin(){
		return uAdminService.viewAll();
	}
	
	@PostMapping("/save")
	public void postUAdmin(@RequestBody UAdmin uAdmin) {
		uAdminService.save(uAdmin);
	}
	
	@PutMapping("/update")
	public void putUAdmin(@RequestBody UAdmin uAdmin) {
		uAdminService.update(uAdmin);
	}
	
	@DeleteMapping("/delete/{idUAdmin}")
	public void deleteUAdmin(@PathVariable("idUAdmin") Integer id) {
		uAdminService.delete(id);
	} 
}
