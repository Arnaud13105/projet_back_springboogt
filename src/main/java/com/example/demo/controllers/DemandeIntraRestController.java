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

import com.example.demo.entities.DemandeIntra;
import com.example.demo.services.IDemandeIntraService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class DemandeIntraRestController {

	@Autowired
	private IDemandeIntraService demandeIntraService;

	@GetMapping("/demandeintra")
	public ResponseEntity<List<DemandeIntra>> getAll() {
		return new ResponseEntity<List<DemandeIntra>>(demandeIntraService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/demandeintra")
	public ResponseEntity<DemandeIntra> create(@RequestBody DemandeIntra demandeIntra) {
		return new ResponseEntity<DemandeIntra>(demandeIntraService.saveOrUpdate(demandeIntra), HttpStatus.CREATED);
	}

	@GetMapping("/demandeintra/{id}")
	public ResponseEntity<DemandeIntra> getById(@PathVariable long id) {
		return demandeIntraService.findById(id).map((dIntra) -> {
			return new ResponseEntity<DemandeIntra>(dIntra, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande Intra entreprise avec l'id " + id + "n'existe pas"));

	}

	@PutMapping("/demandeintra/{id}")
	public ResponseEntity<DemandeIntra> editById(@PathVariable long id, @RequestBody @Valid DemandeIntra demandeIntra) {
		return demandeIntraService.findById(id).map((dIntra) -> {
			dIntra.setNom(demandeIntra.getNom());
			dIntra.setPrenom(demandeIntra.getPrenom());
			dIntra.setEntreprise(demandeIntra.getEntreprise());
			dIntra.setTelephone(demandeIntra.getTelephone());
			dIntra.setDateDebut(demandeIntra.getDateDebut());
			dIntra.setLieu(demandeIntra.getLieu());
			dIntra.setEligibleCPF(demandeIntra.getEligibleCPF());
			dIntra.setNbrInscrits(demandeIntra.getNbrInscrits());
			demandeIntraService.saveOrUpdate(dIntra);
			return new ResponseEntity<DemandeIntra>(dIntra, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande Intra entreprise avec l'id" + id + "n'existe pas"));
	}

	@DeleteMapping("/demandeintra/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return demandeIntraService.findById(id).map((dIntra) -> {
			demandeIntraService.delete(dIntra.getId());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La demande intra avec l'id " + id + "n'existe pas"));
	}

	@GetMapping("/demandeintra/showSome/{entreprise}")
	public ResponseEntity<List<DemandeIntra>> getAll2(@PathVariable(value = "entreprise") String entreprise) {
		return new ResponseEntity<List<DemandeIntra>>(demandeIntraService.findByEntreprise(entreprise), HttpStatus.OK);
	}

	@GetMapping("/demandeintra/showSome/email/{email}")
	public ResponseEntity<List<DemandeIntra>> getAll3(@PathVariable(value = "email") String email) {
		return new ResponseEntity<List<DemandeIntra>>(demandeIntraService.findByEmail(email), HttpStatus.OK);
	}

}
