package com.example.demo.entities;

import javax.persistence.Column;
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
@Table(name = "demande_personnalisee")
public class DemandePerso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;
	@NonNull
	private String nom;
	@NonNull
	private String prenom;
	@NonNull
	private String entreprise;
	@NonNull
	private String telephone;
	@Column(name = "eligible_cpf")
	@NonNull
	private String eligibleCPF;
	@NonNull
	private String besoins;
	@NonNull
	private String objectifs;

}
