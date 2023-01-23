package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	/* @Temporal(TemporalType.DATE) */
	@NonNull
	private String dateDebut;
	@NonNull
	private String lieu;
	@Column(name = "eligible_cpf")
	@NonNull
	private String eligibleCPF;
	
	@Column(name = "nbr_inscrit")
	private int nbrInscrits;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;

}
