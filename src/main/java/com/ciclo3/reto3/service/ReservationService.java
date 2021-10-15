package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void update(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void delete(Integer id) {
		reservationRepository.deleteById(id);
	}
	
	public List<Reservation> viewAll(){
		return reservationRepository.findAll();
}
}
