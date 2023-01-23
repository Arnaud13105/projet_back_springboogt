package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@NonNull
	@Column(name = "eligible_cpf")
<<<<<<< HEAD
=======
	@NonNull
>>>>>>> 7edc24f7a89dbe2ea75d9351c4f3dc8b4cc9492b
	private String eligibleCPF;
	@NonNull
	private String besoins;
	@NonNull
	private String objectifs;
	

<<<<<<< HEAD
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;

=======
>>>>>>> 7edc24f7a89dbe2ea75d9351c4f3dc8b4cc9492b
}
