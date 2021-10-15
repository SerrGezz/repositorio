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

import com.ciclo3.reto3.model.Score;
import com.ciclo3.reto3.service.ScoreService;

@RestController
@RequestMapping("api/Score")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
			
	@GetMapping("/all")
	public List<Score> getScore(){
		return scoreService.viewAll();
	}
	
	@PostMapping("/save")
	public void postScore(@RequestBody Score score) {
		scoreService.save(score);
	}
	
	@PutMapping("/update")
	public void putScore(@RequestBody Score score) {
		scoreService.update(score);
	}
	
	@DeleteMapping("delete/{idScore}")
	public void deleteScore(@PathVariable("idScore") Integer id) {
		scoreService.delete(id);
	} 

}
