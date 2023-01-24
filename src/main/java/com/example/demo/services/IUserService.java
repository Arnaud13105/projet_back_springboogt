package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface IUserService extends IService<User> {
	
	List<User> findByNom(String nom);

	List<User> findByPrenom(String prenom);

	List<User> findByEmail(String email);

	List<User> findByEntreprise(String entreprise);

	List<User> findByStatut(String statut);

}


