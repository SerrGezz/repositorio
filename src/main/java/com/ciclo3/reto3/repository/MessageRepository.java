package com.ciclo3.reto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.reto3.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
