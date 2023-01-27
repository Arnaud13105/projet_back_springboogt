package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Formation;
import com.example.demo.entities.Session;
import com.example.demo.services.ISessionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class SessionRestController {

	@Autowired
	private ISessionService sessionService;

	@GetMapping("/sessions")
	public ResponseEntity<List<Session>> getAll() {
		return new ResponseEntity<List<Session>>(sessionService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/sessions")
	public ResponseEntity<Session> create(@RequestBody Session session) {
		return new ResponseEntity<Session>(sessionService.saveOrUpdate(session), HttpStatus.CREATED);

	}

	@PutMapping("/sessions/{id}")
	public ResponseEntity<Session> editById(@PathVariable long id, @RequestBody Session session) {
		return sessionService.findById(id).map((p) -> {
			p.setDateDebut(session.getDateDebut());
			p.setDateFin(session.getDateFin());
			p.setLieu(session.getLieu());
			p.setSalle(session.getSalle());
			p.setFormateur(session.getFormateur());
			p.setSupport(session.getSupport());
			p.setAutres(session.getAutres());
			p.setFormation(session.getFormation());
			sessionService.saveOrUpdate(session);
			return new ResponseEntity<Session>(p, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La session avec l'id " + id + " n'existe pas"));
	}

	@GetMapping("/sessions/{id}")
	public ResponseEntity<Session> getById(@PathVariable long id) {
		return sessionService.findById(id).map((p) -> {
			return new ResponseEntity<Session>(p, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La session avec l'id " + id + " n'existe pas"));
	}

	@DeleteMapping("/sessions/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return sessionService.findById(id).map((p) -> {
			sessionService.delete(p.getId());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La session avec l'id " + id + " n'existe pas"));
	}

	@GetMapping("/showSome5") // showSome5?start=yyyy-mm-dd
	// (pattern = "yyyy/mm/dd")
	public ResponseEntity<List<Session>> getAll1(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut) {
		return new ResponseEntity<List<Session>>(sessionService.findByDateDebut(dateDebut), HttpStatus.OK);

	}

	@GetMapping("/showSome6/{lieu}")
	public ResponseEntity<List<Session>> getAll2(@PathVariable(value = "lieu") String lieu) {
		return new ResponseEntity<List<Session>>(sessionService.findByLieu(lieu), HttpStatus.OK);

	}

	@GetMapping("/showSome7/{salle}")
	public ResponseEntity<List<Session>> getAll3(@PathVariable(value = "salle") String salle) {
		return new ResponseEntity<List<Session>>(sessionService.findBySalle(salle), HttpStatus.OK);

	}

	@GetMapping("/showSome8/{formationId}")
	public ResponseEntity<List<Session>> getAll4(@PathVariable(value = "formationId") long formationId) {
		return new ResponseEntity<List<Session>>(sessionService.findByFormationId(formationId), HttpStatus.OK);

	}

}
