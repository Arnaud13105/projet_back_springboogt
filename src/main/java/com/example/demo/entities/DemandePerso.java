package com.example.demo.entities;

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
@Table(name = "demande_personnalisee")
public class DemandePerso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String entreprise;
	private String telephone;
	@Column(name = "eligible_cpf")
	private boolean eligibleCPF;
	private String besoins;
	private String objectifs;

	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;

}
