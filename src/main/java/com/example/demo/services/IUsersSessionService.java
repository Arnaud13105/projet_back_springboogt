package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.UserSession;
import com.example.demo.entities.UserSessionId;

public interface IUsersSessionService extends IService<UserSession> {

	List<UserSession> findAll();

	Optional<UserSession> findById(UserSessionId id);

	boolean delete(UserSessionId id);

	List<UserSession> findUsersByIdSession(long idSession);

	List<UserSession> findSessionsByIdUser(long idUser);

}
