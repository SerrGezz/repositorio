package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Score;
import com.ciclo3.reto3.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	public void save(Score score) {
		scoreRepository.save(score);
	}
	
	public void update(Score score) {
		scoreRepository.save(score);
	}
	
	public void delete(Integer id) {
		scoreRepository.deleteById(id);
	}
	
	public List<Score> viewAll(){
			return scoreRepository.findAll();
	}
}
