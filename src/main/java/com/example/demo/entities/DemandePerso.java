package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

	/**
	 * 
	 */
	public DemandePerso() {
		super();
	}

	
	public DemandePerso(Long id, String nom, String prenom, String entreprise, String telephone,
			boolean eligibleCPF, String besoins, String objectifs) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom= prenom;
		this.entreprise = entreprise;
		this.telephone = telephone;
		this.eligibleCPF = eligibleCPF;
		this.besoins = besoins;
		this.objectifs = objectifs;
	}

	
	public DemandePerso(String nom, String prenom, String entreprise, String telephone, boolean eligibleCPF,
			String besoins, String objectifs) {
		super();
		this.nom = nom;
		this.prenom= prenom;
		this.entreprise = entreprise;
		this.telephone = telephone;
		this.eligibleCPF = eligibleCPF;
		this.besoins = besoins;
		this.objectifs = objectifs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public String getprenom() {
		return prenom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isEligibleCPF() {
		return eligibleCPF;
	}

	public void setEligibleCPF(boolean eligibleCPF) {
		this.eligibleCPF = eligibleCPF;
	}

	public String getBesoins() {
		return besoins;
	}

	public void setBesoins(String besoins) {
		this.besoins = besoins;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	@Override
	public String toString() {
		return "DemandePerso [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", entreprise="
				+ entreprise + ", telephone=" + telephone + ", eligibleCPF=" + eligibleCPF + ", besoins=" + besoins
				+ ", objectifs=" + objectifs + "]";
	}

}
