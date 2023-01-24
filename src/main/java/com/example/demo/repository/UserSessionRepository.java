package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserSession;
import com.example.demo.entities.UserSessionId;

public interface UserSessionRepository extends JpaRepository<UserSession, UserSessionId> {
	List<UserSession> findAll();

	List<UserSession> findSessionsByIdUser(long idUser);

	List<UserSession> findUsersByIdSession(long idSession);
}
