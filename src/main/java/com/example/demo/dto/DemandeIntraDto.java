package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeIntraDto {

	@NotEmpty()
	@Size(min = 2, message = "Nom doit contenir minimum 2 caractères")
	private String nom;

	@NotEmpty()
	@Size(min = 2, message = "Prenom doit contenir minimum 2 caractères")
	private String prenom;

	@NotEmpty()
	@Size(min = 2, message = "l'entreprise doit contenir minimum 2 caractères")
	private String entreprise;

	@NotEmpty()
	@Size(max = 10, message = "numéro de téléphone doit contenir minimum 10 caractères")
	private String telephone;

	@NotEmpty()
	@Size(min = 2, message = "L'email doit contenir minimum 2 caractères")
	private String email;

	@NotNull()
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // (pattern = "yyyy/mm/dd")
	private LocalDate dateDebut;

<<<<<<< HEAD
=======
//	@NotEmpty()
//	@Size(max = 10, message = "Lieu peut être 'local de formation' = Formation ou 'local de l'entreprise' = Entreprise")
>>>>>>> d27d5f1674705ac058cfe6f32da41e3f633feef7
	private String lieu;

	@NotEmpty()
	@Size(max = 3, message = "Etes-vous éligible au CPF : Oui ou Non")
	private String eligibleCPF;

	@NotNull()
	@Digits(integer = 3, fraction = 0, message = "age doit contenir au maximum 3 entiers")
	private int nbrInscrits;

}
