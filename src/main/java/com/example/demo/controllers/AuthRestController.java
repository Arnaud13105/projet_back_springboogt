package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.IAuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthRestController {

	@Autowired
	private IAuthService authService;
	
	@GetMapping("/user/showSome/auth/{email}/{password}")
	public  ResponseEntity<User> getAll3(
			@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		return new ResponseEntity<User> (authService.findByEmailAndPassword(email, password), HttpStatus.OK);
	}
	
	
	
}
