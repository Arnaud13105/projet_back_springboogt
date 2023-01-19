package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Date date;
	private String email;
	private String adresse;
	private String entreprise;
	private String telephone;
	private String statut;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param email
	 * @param entreprise
	 * @param telephone
	 * @param statut
	 */
	public User(Long id, String nom, String prenom, Date date, String email, String entreprise, String telephone,
			String statut, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = nom;
		this.date = date;
		this.email = email;
		this.entreprise = entreprise;
		this.telephone = telephone;
		this.statut = statut;
		this.adresse = adresse;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date + ", email=" + email
				+ ", adressse=" + adresse + ", entreprise=" + entreprise + ", telephone=" + telephone + ", statut="
				+ statut + "]";
	}

}
