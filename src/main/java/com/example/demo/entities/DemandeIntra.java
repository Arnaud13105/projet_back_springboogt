package com.example.demo.entities;

import java.sql.Date;

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

@Entity
@Data
@NoArgsConstructor
@Table(name = "demande_intra")
public class DemandeIntra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String entreprise;
	private String telephone;
	@Column(name = "date_debut")
	private Date dateDebut;
	private String lieu;
	@Column(name = "eligible_cpf")
	private boolean eligibleCPF;
	@Column(name = "nbr_inscrit")
	private int nbrInscrits;

	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;

}
