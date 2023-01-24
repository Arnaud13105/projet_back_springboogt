package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandePersoDto {

	@NotEmpty()
	@Size(min = 2, message = "Le nom doit contenir minimum 2 caractères")
	private String nom;

	@NotEmpty()
	@Size(min = 2, message = "Le prenom doit contenir minimum 2 caractères")
	private String prenom;

	@NotEmpty()
	@Size(min = 2, message = "L'email doit contenir minimum 2 caractères")
	private String email;

	@NotEmpty()
	@Size(min = 2, message = "entreprise doit contenir minimum 2 caractères")
	private String entreprise;

	@NotEmpty()
	@Size(min = 10, message = "telephone doit contenir minimum 10 caractères")
	private String telephone;

	@NotEmpty()
	@Size(max = 3, message = "Etes-vous éligible au CPF : Oui ou Non")
	private String eligibleCPF;

	@NotEmpty()
	@Size(min = 2, message = "Les besoisns doit contenir minimum 2 caractères")
	private String besoins;

	@NotEmpty()
	@Size(min = 2, message = "Les objectifs doit contenir minimum 2 caractères")
	private String objectifs;

}
