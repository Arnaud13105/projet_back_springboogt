package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "demande_intra")
public class DemandeIntra {

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
	private String email;
	@Column(name = "date_debut")
	@NonNull
	private LocalDate dateDebut;
	@NonNull
	private String lieu;
	@Column(name = "eligible_cpf")
	@NonNull
	private String eligibleCPF;

	@Column(name = "nbr_inscrit")
	private int nbrInscrits;

	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;

}
