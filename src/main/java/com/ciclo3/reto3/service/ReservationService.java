package com.ciclo3.reto3.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.model.custom.CountClient;
import com.ciclo3.reto3.model.custom.StatusAmount;
import com.ciclo3.reto3.repository.ReservationRepository;


@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getAll(){
		return reservationRepository.getAll();
	}
	
	public Optional<Reservation> getReservation(int id){
		return reservationRepository.getReservation(id);
	}
	
	public Reservation save(Reservation reservation) {
		if(reservation.getIdReservation()==null) {
			return reservationRepository.save(reservation);
		}else {
			Optional<Reservation> reservationOptional=reservationRepository.getReservation(reservation.getIdReservation());
			if(reservationOptional.isEmpty()) {
				return reservationRepository.save(reservation);
			}else {
				return reservation;
			}
		}
	}
	
	public Reservation update(Reservation reservation) {
		if(reservation.getIdReservation()!=null) {
			Optional<Reservation> e=reservationRepository.getReservation(reservation.getIdReservation());
			if(!e.isEmpty()) {
				if(reservation.getStartDate()!=null) {
					e.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate()!=null) {
					e.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if(reservation.getStatus()!=null) {
					e.get().setStatus(reservation.getStatus());
				}
				if(reservation.getMachine()!=null) {
					e.get().setMachine(reservation.getMachine());
				}
				if(reservation.getClient()!=null) {
					e.get().setClient(reservation.getClient());
				}
				if(reservation.getScore()!=null) {
					e.get().setScore(reservation.getScore());
				}
				reservationRepository.save(e.get());
				return e.get();
			}else {
				return reservation;
			}
		}else {
			return reservation;
		}	
	}
		
	public boolean delete(int id) {
		Boolean bool = getReservation(id).map(reservation -> {
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return bool;
	}
	
	public List<CountClient> getTopClients(){
		return reservationRepository.getTopClients();
	}
	
	public StatusAmount getStatusReport() { 
		List<Reservation> completed=reservationRepository.getReservationsByStatus("completed");
		List<Reservation> cancelled=reservationRepository.getReservationsByStatus("cancelled");
		
		StatusAmount staAm = new StatusAmount(completed.size(), cancelled.size());
		return staAm;
	}
	
	public List<Reservation> getReservationPeriod(String d1, String d2){
		
		SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
		Date dOne = new Date();
		Date dTwo = new Date();
		try {
			dOne = parser.parse(d1);
			dTwo = parser.parse(d2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(dOne.before(dTwo)) {
			return reservationRepository.getReservationPeriod(dOne, dTwo);
		}
		return new ArrayList<>();
	}
}
