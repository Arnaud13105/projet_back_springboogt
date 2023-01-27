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

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;
import com.example.demo.services.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private IUserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);

	}

	@PostMapping("/user")
	public ResponseEntity<User> create(@RequestBody @Valid UserDto userDto) {
		User user = new User();
		user.setNom(userDto.getNom());
		user.setPrenom(userDto.getPrenom());
		user.setDateNaissance(userDto.getDateNaissance());// "yyyy/mm/dd
		user.setEmail(userDto.getEmail());
		user.setAdresse(userDto.getAdresse());
		user.setTelephone(userDto.getTelephone());
		user.setEntreprise(userDto.getEntreprise());
		user.setStatut(userDto.getStatut());
		user.setPassword(userDto.getPassword());
		return new ResponseEntity<User>(userService.saveOrUpdate(user), HttpStatus.CREATED);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		return userService.findById(id).map((user) -> {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "L'user l'id " + id + "n'existe pas"));

	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> editById(@PathVariable long id, @RequestBody @Valid UserDto userDto) {
		return userService.findById(id).map((u) -> {
			u.setNom(userDto.getNom());
			u.setPrenom(userDto.getPrenom());
			u.setDateNaissance(userDto.getDateNaissance());// "yyyy/mm/dd
			u.setEmail(userDto.getEmail());
			u.setAdresse(userDto.getAdresse());
			u.setTelephone(userDto.getTelephone());
			u.setEntreprise(userDto.getEntreprise());
			u.setStatut(userDto.getStatut());
			userService.saveOrUpdate(u);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user avec l'id" + id + "n'existe pas"));
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return userService.findById(id).map((user) -> {
			userService.delete(user.getId());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user l'id " + id + "n'existe pas"));
	}

	@GetMapping("/user/showSome/{entreprise}")
	public ResponseEntity<List<User>> getAll2(@PathVariable(value = "entreprise") String entreprise) {
		return new ResponseEntity<List<User>>(userService.findByEntreprise(entreprise), HttpStatus.OK);
	}

	@GetMapping("/user/showSome/email/{email}")
	public ResponseEntity<List<User>> getAll3(@PathVariable(value = "email") String email) {
		return new ResponseEntity<List<User>>(userService.findByEmail(email), HttpStatus.OK);

	}

	@GetMapping("/user/showSome/statut/{statut}")
	public ResponseEntity<List<User>> getAll4(@PathVariable(value = "statut") String statut) {
		return new ResponseEntity<List<User>>(userService.findByStatut(statut), HttpStatus.OK);
	}
}
