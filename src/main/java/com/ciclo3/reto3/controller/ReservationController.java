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

import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.model.custom.CountClient;
import com.ciclo3.reto3.model.custom.StatusAmount;
import com.ciclo3.reto3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {	
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/all")
	public List<Reservation> getReservation(){
		return reservationService.getAll();
	}
		
	@GetMapping("/{idReservation}")
	public Optional<Reservation> getReservation1(@PathVariable("idReservation") int id){
		return reservationService.getReservation(id);
	}
		
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation postReservation(@RequestBody Reservation reservation) {
		return reservationService.save(reservation);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation update(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	}
	
	@DeleteMapping("/{idReservation}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("idReservation") int reservationId) {
		return reservationService.delete(reservationId);
	}

	@GetMapping("/report-status")
	public StatusAmount getReservationStatusAmount() {
		return reservationService.getStatusReport();
	}
	
	@GetMapping("/report-clients")
	public List<CountClient> getCountClient(){
		return reservationService.getTopClients();
	}
	
	@GetMapping("/report-dates/{startDate}/{devolutionDate}")
	public List<Reservation> getDateReport(@PathVariable("startDate") String dOne, @PathVariable("devolutionDate")String dTwo){
		return reservationService.getReservationPeriod(dOne, dTwo);
	}
}
