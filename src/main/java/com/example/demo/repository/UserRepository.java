package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByNom(String nom);

	List<User> findByPrenom(String prenom);

	List<User> findByEmail(String email);

	List<User> findByEntreprise(String entreprise);

	List<User> findByStatut(String statut);
	

}
