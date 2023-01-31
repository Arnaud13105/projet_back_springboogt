package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findByDateDebut(LocalDate dateDebut);

	List<Session> findByLieu(String lieu);

	List<Session> findBySalle(String salle);

	List<Session> findSessionsByFormationId(long idFormation);
	

}
