package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.Formation;
import com.example.demo.entities.Session;

public interface ISessionService extends IService<Session> {

	List<Session> findByDateDebut(LocalDate dateDebut);

	List<Session> findByLieu(String lieu);

	List<Session> findBySalle(String salle);

	List<Session> findByFormationId(long formationId);

}
