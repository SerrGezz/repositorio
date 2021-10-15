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

import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.service.ReservationService;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
	
	ReservationService rest = new ReservationService();
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/all")
	public List<Reservation> getReservation(){ 		
		return reservationService.viewAll();
	}
	
	@PostMapping("/save")
	public void postReservation(@RequestBody Reservation reservation) {		
		reservationService.save(reservation);
	}
	
	@PutMapping("/update")
	public void putReservation(@RequestBody Reservation reservation) {
		reservationService.update(reservation);
	}
	
	@DeleteMapping("/delete/{idReservation}")
	public void deleteReservation(@PathVariable("idReservation") Integer id) {
		reservationService.delete(id);
	}
}
