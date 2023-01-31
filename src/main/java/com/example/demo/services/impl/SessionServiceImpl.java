package com.example.demo.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.services.ISessionService;

@Service("SessionService")
public class SessionServiceImpl implements ISessionService {

	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public List<Session> findAll() {
		// TODO Auto-generated method stub
		return sessionRepository.findAll();
	}

	@Override
	public Session saveOrUpdate(Session o) {
		// TODO Auto-generated method stub
		return sessionRepository.save(o);
	}

	@Override
	public Optional<Session> findById(long id) {
		// TODO Auto-generated method stub
		return sessionRepository.findById(id);
	}

	@Override
	public boolean delete(long idSessions) {
		sessionRepository.deleteById(idSessions);
		return true;
	}

	@Override
	public List<Session> findByDateDebut(LocalDate dateDebut) {
		// TODO Auto-generated method stub
		return sessionRepository.findByDateDebut(dateDebut);
	}

	@Override
	public List<Session> findByLieu(String lieu) {
		// TODO Auto-generated method stub
		return sessionRepository.findByLieu(lieu);
	}

	@Override
	public List<Session> findBySalle(String salle) {
		// TODO Auto-generated method stub
		return sessionRepository.findBySalle(salle);
	}

	@Override
	public List<Session> getSessionsByFormationId(long idFormation) {
		// TODO Auto-generated method stub
		return sessionRepository.findSessionsByFormationId(idFormation);
	}

}
