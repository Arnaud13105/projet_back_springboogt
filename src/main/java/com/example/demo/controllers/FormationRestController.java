package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Formation;
import com.example.demo.services.IFormationService;

@RestController
@CrossOrigin("*")
public class FormationRestController {

	@Autowired
	private IFormationService formationService;

	@GetMapping("/formations")
	public ResponseEntity<List<Formation>> getAll() {
		return new ResponseEntity<List<Formation>>(formationService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/formations")
	public ResponseEntity<Formation> create(@RequestBody Formation formation) {
		return new ResponseEntity<Formation>(formationService.saveOrUpdate(formation), HttpStatus.CREATED);

	}

	@PutMapping("/formations/{id}")
	public ResponseEntity<Formation> editById(@PathVariable long id, @RequestBody Formation formation) {
		return formationService.findById(id).map((p) -> {
			p.setNomFormation(formation.getNomFormation());
			p.setDomaine(formation.getDomaine());
			p.setTheme(formation.getTheme());
			p.setDescription(formation.getDescription());
			p.setDuree(formation.getDuree());
			p.setPrerequis(formation.getPrerequis());
			p.setPrix(formation.getPrix());
			formationService.saveOrUpdate(formation);
			return new ResponseEntity<Formation>(p, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La Formation avec l'id " + id + "n'existe pas"));
	}

	@GetMapping("/formations/{id}")
	public ResponseEntity<Formation> getById(@PathVariable long id) {
		return formationService.findById(id).map((p) -> {
			return new ResponseEntity<Formation>(p, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La Formation avec l'id " + id + "n'existe pas"));
	}

	@DeleteMapping("/formations/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return formationService.findById(id).map((p) -> {
			formationService.delete(p.getId());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La Formation avec l'id " + id + "n'existe pas"));
	}

	@GetMapping("/showSome1/{nomFormation}")
	public ResponseEntity<List<Formation>> getAll(@PathVariable(value = "nomFormation") String nomFormation) {
		return new ResponseEntity<List<Formation>>(formationService.findByNomFormation(nomFormation), HttpStatus.OK);
	}

	@GetMapping("/showSome2/{domaine}")
	public ResponseEntity<List<Formation>> getAll2(@PathVariable(value = "domaine") String domaine) {
		return new ResponseEntity<List<Formation>>(formationService.findByDomaine(domaine), HttpStatus.OK);
	}

	@GetMapping("/showSome3/{theme}")
	public ResponseEntity<List<Formation>> getAll3(@PathVariable(value = "theme") String theme) {
		return new ResponseEntity<List<Formation>>(formationService.findByTheme(theme), HttpStatus.OK);
	}

	@GetMapping("/showSome4/{prix}")
	public ResponseEntity<List<Formation>> getAll4(@PathVariable(value = "prix") String prix) {
		return new ResponseEntity<List<Formation>>(formationService.findByPrix(prix), HttpStatus.OK);
	}
}
