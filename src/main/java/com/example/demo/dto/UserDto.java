package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@NotEmpty()
	@Size(min = 2, message = "Nom doit contenir minimum 2 caractères")
	private String nom;

	@NotEmpty()
	@Size(min = 2, message = "Prenom doit contenir minimum 2 caractères")
	private String prenom;

	@NotNull()
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "yyyy/mm/dd")
	private LocalDate dateDebut;

	@NotEmpty()
	@Size(min = 2, message = "L'email doit contenir minimum 2 caractères")
	private String email;

	@NotEmpty()
	@Size(min = 2, message = "l'adresse doit contenir minimum 2 caractères")
	private String adresse;

	@NotEmpty()
	@Size(min = 2, message = "entreprise doit contenir minimum 2 caractères")
	private String entreprise;

	@NotEmpty()
	@Size(min = 10, message = "telephone; doit contenir minimum 10 caractères")
	private String telephone;

	@NotEmpty()
	@Size(min = 2, message = "statut doit contenir minimum 2 caractères")
	private String statut;

}