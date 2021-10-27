package com.ciclo3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclo3.reto3.model.Client;
import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.model.custom.CountClient;
import com.ciclo3.reto3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
	
	@Autowired
	private ReservationCrudRepository reservationCrudRepository;
	
	public List<Reservation> getAll(){
		return (List<Reservation>)reservationCrudRepository.findAll();
	}
	
	public Optional<Reservation> getReservation(int id){
		return reservationCrudRepository.findById(id);
	}
	
	public Reservation save(Reservation reservation) {
		return reservationCrudRepository.save(reservation);
	}
	
	public void delete(Reservation reservation) {
		reservationCrudRepository.delete(reservation);
	}
	
	public List<Reservation> getReservationsByStatus(String status){
		return reservationCrudRepository.findAllByStatus(status);
	}
	
	public List<Reservation> getReservationPeriod(Date dOne, Date dTwo){
		return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(dOne, dTwo);
	}
	
	public List<CountClient> getTopClients(){
		List<CountClient> res= new ArrayList<>();
		
		List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
		for(int i=0; i<report.size();i++) {
			
			Client cli=(Client) report.get(i)[0];
			Long cantidad = (Long) report.get(i)[1];
			CountClient cc= new CountClient(cantidad, cli);
			res.add(cc);
		}
		
		return res;
	}
}
