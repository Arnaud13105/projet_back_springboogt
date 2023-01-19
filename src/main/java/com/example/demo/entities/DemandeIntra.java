package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

	/**
	 * 
	 */
	public DemandeIntra() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param entreprise
	 * @param telephone
	 * @param dateDebut
	 * @param lieu
	 * @param eligibleCPF
	 * @param nbrInscrits
	 */
	public DemandeIntra(Long id, String nom, String prenom, String entreprise, String telephone, Date dateDebut,
			String lieu, boolean eligibleCPF, int nbrInscrits) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom= prenom;
		this.entreprise = entreprise;
		this.telephone = telephone;
		this.dateDebut = dateDebut;
		this.lieu = lieu;
		this.eligibleCPF = eligibleCPF;
		this.nbrInscrits = nbrInscrits;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param entreprise
	 * @param telephone
	 * @param dateDebut
	 * @param lieu
	 * @param eligibleCPF
	 * @param nbrInscrits
	 */
	public DemandeIntra(String nom, String prenom, String entreprise, String telephone, Date dateDebut,
			String lieu, boolean eligibleCPF, int nbrInscrits) {
		super();
		this.nom = nom;
		this.prenom= prenom;
		this.entreprise = entreprise;
		this.telephone = telephone;
		this.dateDebut = dateDebut;
		this.lieu = lieu;
		this.eligibleCPF = eligibleCPF;
		this.nbrInscrits = nbrInscrits;
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public boolean isEligibleCPF() {
		return eligibleCPF;
	}

	public void setEligibleCPF(boolean eligibleCPF) {
		this.eligibleCPF = eligibleCPF;
	}

	public int getNbrInscrits() {
		return nbrInscrits;
	}

	public void setNbrInscrits(int nbrInscrits) {
		this.nbrInscrits = nbrInscrits;
	}

	@Override
	public String toString() {
		return "DemandeIntra [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", entreprise="
				+ entreprise + ", telephone=" + telephone + ", dateDebut=" + dateDebut + ", lieu=" + lieu
				+ ", eligibleCPF=" + eligibleCPF + ", nbrInscrits=" + nbrInscrits + "]";
	}

}
