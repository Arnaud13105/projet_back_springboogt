package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;
	@NonNull
	private String nom;
	@NonNull
	private String prenom;
	@NonNull
	private LocalDate dateNaissance;
	@NonNull
	private String email;
	@NonNull
	private String adresse;
	@NonNull
	private String entreprise;
	@NonNull
	private String telephone;
	@NonNull
	private String statut;
	@NonNull
	private String password;

}
