package com.ciclo3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ciclo3.reto3.model.UAdmin;
import com.ciclo3.reto3.service.UAdminService;

@RestController
@RequestMapping("/api/UAdmin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UAdminController {

	@Autowired
	private UAdminService uAdminService;
				
	@GetMapping("/all")
	public List<UAdmin> getUAdmin(){
		return uAdminService.getAll();
	}
		
	@GetMapping("/{idUAdmin}")
	public Optional<UAdmin> getUAdmin1(@PathVariable("idUAdmin") int id){
		return uAdminService.getUAdmin(id);
	}
		
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public UAdmin postCategory(@RequestBody UAdmin uAdmin) {
		return uAdminService.save(uAdmin);
	} 
}
