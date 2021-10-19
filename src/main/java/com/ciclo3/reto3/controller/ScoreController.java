package com.ciclo3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.reto3.model.Score;
import com.ciclo3.reto3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("/all")
	public List<Score> getScore(){
		return scoreService.getAll();
	}
		
	@GetMapping("/{idScore}")
	public Optional<Score> getScore1(@PathVariable("idScore") int id){
		return scoreService.getScore(id);
	}
		
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Score postScore(@RequestBody Score score) {
		return scoreService.save(score);
	} 

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Score update(@RequestBody Score score) {
		return scoreService.update(score);
	}
	
	@DeleteMapping("/{idScore}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("idScore") int scoreId) {
		return scoreService.delete(scoreId);
	}
}
