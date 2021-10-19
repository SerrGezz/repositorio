package com.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Score;
import com.ciclo3.reto3.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	public List<Score> getAll(){
		return scoreRepository.getAll();
	}
	
	public Optional<Score> getScore(int id){
		return scoreRepository.getScore(id);
	}
	
	public Score save(Score score) {
		if(score.getIdScore()==null) {
			return scoreRepository.save(score);
		}else {
			Optional<Score> scoreOptional=scoreRepository.getScore(score.getIdScore());
			if(scoreOptional.isEmpty()) {
				return scoreRepository.save(score);
			}else {
				return score;
			}
		}
	}
	
	public Score update(Score score) {
		if(score.getIdScore()!=null) {
			Optional<Score> e=scoreRepository.getScore(score.getIdScore());
			if(!e.isEmpty()) {
				if(score.getScore()!=null) {
					e.get().setScore(score.getScore());
				}
				if(score.getReservation()!=null) {
					e.get().setReservation(score.getReservation());
				}
				scoreRepository.save(e.get());
				return e.get();
			}else {
				return score;
			}
		}else {
			return score;
		}	
	}
		
	public boolean delete(int id) {
		Boolean bool = getScore(id).map(score -> {
			scoreRepository.delete(score);
			return true;
		}).orElse(false);
		return bool;
	}
}
