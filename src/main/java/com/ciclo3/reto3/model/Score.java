package com.ciclo3.reto3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idScore;
	private Integer score;
	
	@OneToOne
	private Reservation reservation;
	
	public Score() {}

	public Integer getIdScore() {
		return idScore;
	}

	public void setIdScore(Integer idScore) {
		this.idScore = idScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
}
