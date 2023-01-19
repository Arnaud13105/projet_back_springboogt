package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nom_formation")
	private String nomFormation;
	@Column(name = "domaine")
	private String domaine;
	@Column(name = "theme")
	private String theme;
	@Column(name = "description")
	private String description;
	@Column(name = "prix")
	private String prix;
	@Column(name = "duree")
	private String duree;
	@Column(name = "prerequis")
	private String prerequis;

	/**
	 * 
	 */
	public Formation() {
		super();
	}

	/**
	 * @param id
	 * @param nomFormation
	 * @param domaine
	 * @param theme
	 * @param description
	 * @param prix
	 * @param duree
	 * @param prerequis
	 */
	public Formation(Long id, String nomFormation, String domaine, String theme, String description, String prix,
			String duree, String prerequis) {
		super();
		this.id = id;
		this.nomFormation = nomFormation;
		this.domaine = domaine;
		this.theme = theme;
		this.description = description;
		this.prix = prix;
		this.duree = duree;
		this.prerequis = prerequis;
	}

	/**
	 * @param nomFormation
	 * @param domaine
	 * @param theme
	 * @param description
	 * @param prix
	 * @param duree
	 * @param prerequis
	 */
	public Formation(String nomFormation, String domaine, String theme, String description, String prix, String duree,
			String prerequis) {
		super();
		this.nomFormation = nomFormation;
		this.domaine = domaine;
		this.theme = theme;
		this.description = description;
		this.prix = prix;
		this.duree = duree;
		this.prerequis = prerequis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", nomFormation=" + nomFormation + ", domaine=" + domaine + ", theme=" + theme
				+ ", description=" + description + ", prix=" + prix + ", duree=" + duree + ", prerequis=" + prerequis
				+ "]";
	}

}
