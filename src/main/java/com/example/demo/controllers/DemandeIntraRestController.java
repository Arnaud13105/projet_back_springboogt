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

import com.example.demo.dto.DemandeIntraDto;
import com.example.demo.entities.DemandeIntra;
import com.example.demo.services.IDemandeIntraService;
import com.example.demo.services.IFormationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class DemandeIntraRestController {

	@Autowired
	private IDemandeIntraService demandeIntraService;

	@Autowired
	private IFormationService formationService;

	@GetMapping("/demandeintra")
	public ResponseEntity<List<DemandeIntra>> getAll() {
		return new ResponseEntity<List<DemandeIntra>>(demandeIntraService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/demandeintra")
	public ResponseEntity<DemandeIntra> create(@RequestBody @Valid DemandeIntraDto demandeIntraDto) {
		DemandeIntra demandeIntra = new DemandeIntra();
		demandeIntra.setNom(demandeIntraDto.getNom());
		demandeIntra.setPrenom(demandeIntraDto.getPrenom());
		demandeIntra.setEntreprise(demandeIntraDto.getEntreprise());
		demandeIntra.setTelephone(demandeIntraDto.getTelephone());
		demandeIntra.setEmail(demandeIntraDto.getEmail());
		demandeIntra.setDateDebut(demandeIntraDto.getDateDebut());// 2022/01/03 ou 2022-01-03
		demandeIntra.setLieu(demandeIntraDto.getLieu());
		demandeIntra.setEligibleCPF(demandeIntraDto.getEligibleCPF());
		demandeIntra.setNbrInscrits(demandeIntraDto.getNbrInscrits());
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
	public ResponseEntity<DemandeIntra> editById(@PathVariable long id,
			@RequestBody @Valid DemandeIntraDto demandeIntraDto) {
		return demandeIntraService.findById(id).map((dIntra) -> {
			dIntra.setNom(demandeIntraDto.getNom());
			dIntra.setPrenom(demandeIntraDto.getPrenom());
			dIntra.setEntreprise(demandeIntraDto.getEntreprise());
			dIntra.setTelephone(demandeIntraDto.getTelephone());
			dIntra.setEmail(demandeIntraDto.getEmail());
			dIntra.setDateDebut(demandeIntraDto.getDateDebut());// 2022/01/03 ou 2022-01-03
			dIntra.setLieu(demandeIntraDto.getLieu());
			dIntra.setEligibleCPF(demandeIntraDto.getEligibleCPF());
			dIntra.setNbrInscrits(demandeIntraDto.getNbrInscrits());
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

	@GetMapping("/formations/{formationId}/demandeintra/{demandeIntraId}")
	public ResponseEntity<DemandeIntra> getDemandeIntraByFormationId(
			@PathVariable(value = "formationId") long formationId,
			@PathVariable(value = "demandeIntraId") long demandeIntraId) {
		formationService.findById(formationId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"formation not found with id : " + formationId));
		demandeIntraService.findById(demandeIntraId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"demande intra not found with id : " + demandeIntraId));
		DemandeIntra demandeIntra = demandeIntraService.getOneDemandeIntraByFormation(formationId, demandeIntraId)
				.get();
		return new ResponseEntity<>(demandeIntra, HttpStatus.CREATED);
	}

}
