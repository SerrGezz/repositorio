package com.ciclo3.reto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.reto3.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
