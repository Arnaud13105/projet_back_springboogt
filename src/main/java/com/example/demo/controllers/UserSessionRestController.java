package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Session;
import com.example.demo.entities.User;
import com.example.demo.entities.UserSession;
import com.example.demo.repository.SessionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserSessionRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/UserSession")
public class UserSessionRestController {

	@Autowired
	private UserSessionRepository userSessionRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping()
	public ResponseEntity<List<UserSession>> getAll() {
		return new ResponseEntity<>(userSessionRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/allSessions/{idUser}")
	public ResponseEntity<List<Session>> getAllSessionsByUser(@PathVariable long idUser) {
		List<UserSession> userSessions = userSessionRepository.findSessionsByIdUser(idUser);
		List<Long> formationIdList = userSessions.stream().map((item) -> item.getIdSession())
				.collect(Collectors.toList());
		return new ResponseEntity<>(sessionRepository.findAllById(formationIdList), HttpStatus.OK);
	}

	@GetMapping("/allUsers/{idSession}")
	public ResponseEntity<List<User>> getAllUsersBySession(@PathVariable long idSession) {
		List<UserSession> userSessions = userSessionRepository.findUsersByIdSession(idSession);
		List<Long> userIdList = userSessions.stream().map((item) -> item.getIdUser()).collect(Collectors.toList());
		return new ResponseEntity<>(userRepository.findAllById(userIdList), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<UserSession> save(@RequestBody UserSession userSession) {
		return new ResponseEntity<>(userSessionRepository.save(userSession), HttpStatus.OK);
	}

	@DeleteMapping()
	public boolean deleteUserSession(@RequestBody UserSession userSession) {
		userSessionRepository.delete(userSession);
		return true;
	}

}
