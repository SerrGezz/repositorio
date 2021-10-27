package com.ciclo3.reto3.repository.crud;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ciclo3.reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

	@Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
	public List<Object[]> countTotalReservationByClient();
	
	public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dOne, Date dTwo);
	
	public List<Reservation> findAllByStatus(String status);
}
