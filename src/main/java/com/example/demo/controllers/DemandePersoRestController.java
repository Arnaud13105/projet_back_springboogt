package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.DemandePerso;
import com.example.demo.services.IDemandePersoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class DemandePersoRestController {

	@Autowired
	private IDemandePersoService demandePersoService;

	@GetMapping("/demandeperso")
	public ResponseEntity<List<DemandePerso>> getAll() {
		return new ResponseEntity<List<DemandePerso>>(demandePersoService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/demandeperso")
	public ResponseEntity<DemandePerso> create(@RequestBody DemandePerso demandePerso) {
		return new ResponseEntity<DemandePerso>(demandePersoService.saveOrUpdate(demandePerso), HttpStatus.CREATED);
	}

	@GetMapping("/demandeperso/{id}")
	public ResponseEntity<DemandePerso> getById(@PathVariable long id) {
		return demandePersoService.findById(id).map((dPerso) -> {
			return new ResponseEntity<DemandePerso>(dPerso, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande personnalisée avec l'id " + id + "n'existe pas"));

	}

	@PutMapping("/demandeperso/{id}")
	public ResponseEntity<DemandePerso> editById(@PathVariable long id, @RequestBody @Valid DemandePerso demandePerso) {
		return demandePersoService.findById(id).map((dPerso) -> {
			dPerso.setNom(demandePerso.getNom());
			dPerso.setPrenom(demandePerso.getPrenom());
			dPerso.setEntreprise(demandePerso.getEntreprise());
			dPerso.setTelephone(demandePerso.getTelephone());
			dPerso.setEligibleCPF(demandePerso.getEligibleCPF());
			dPerso.setBesoins(demandePerso.getBesoins());
			dPerso.setObjectifs(demandePerso.getObjectifs());
			demandePersoService.saveOrUpdate(dPerso);
			return new ResponseEntity<DemandePerso>(dPerso, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande personnalisée avec l'id" + id + "n'existe pas"));
	}

	@DeleteMapping("/demandeperso/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return demandePersoService.findById(id).map((dPerso) -> {
			demandePersoService.delete(dPerso.getId());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande personnalisée avec l'id " + id + "n'existe pas"));
	}

	@GetMapping("/demandeperso/showSome/{entreprise}")
	public ResponseEntity<List<DemandePerso>> getAll2(@PathVariable(value = "entreprise") String entreprise) {
		return new ResponseEntity<List<DemandePerso>>(demandePersoService.findByEntreprise(entreprise), HttpStatus.OK);
	}

}
