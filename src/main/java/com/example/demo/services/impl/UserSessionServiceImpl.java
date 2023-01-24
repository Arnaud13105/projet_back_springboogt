package com.example.demo.services.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Session;
import com.example.demo.entities.User;
import com.example.demo.entities.UserSession;
import com.example.demo.entities.UserSessionId;
import com.example.demo.repository.UserSessionRepository;
import com.example.demo.services.IUsersSessionService;

public class UserSessionServiceImpl implements IUsersSessionService {
	

	@Autowired
	private UserSessionRepository userSessionRepository;
	
	@Override
	public Optional<UserSession> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserSession> findAll() {
		return userSessionRepository.findAll();
	}

	@Override
	public UserSession saveOrUpdate(UserSession o) {
		
		return userSessionRepository.save(o);
	}

	@Override
	public Optional<UserSession> findById(UserSessionId id) {
		return userSessionRepository.findById(id);
	}

	@Override
	public boolean delete(UserSessionId id) {
		userSessionRepository.deleteById(id);
		return true;
	}

	@Override
	public List<UserSession> findUsersByIdSession(long idSession) {
		return userSessionRepository.findUsersByIdSession(idSession);

	}

	@Override
	public List<UserSession> findSessionsByIdUser(long idUser) {
		return userSessionRepository.findSessionsByIdUser(idUser);	
	}

}	