package com.ciclo3.reto3.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties("creationDate")
	private Integer idReservation;
	private Date startDate;
	private Date devolutionDate;
	private LocalDateTime creationDate = LocalDateTime.now();
	private String status = "Created";
	
	@ManyToOne
	@JoinColumn(name = "machine")
	@JsonIgnoreProperties({"reservations", "client"})
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name = "client")
	@JsonIgnoreProperties({"reservations", "messages"})
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "score")
	@JsonProperty("score")
	private Score score;
	
	public Reservation() {}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
