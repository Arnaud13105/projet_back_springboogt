package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;
	@NonNull
	@Column(name = "nom_formation")
	private String nomFormation;
	@NonNull
	@Column(name = "domaine")
	private String domaine;
	@NonNull
	@Column(name = "theme")
	private String theme;
	@NonNull
	@Column(name = "description")
	private String description;
	@NonNull
	@Column(name = "prix")
	private String prix;
	@NonNull
	@Column(name = "duree")
	private String duree;
	@NonNull
	@Column(name = "prerequis")
	private String prerequis;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "formation")
	private List<Session> sessions = new ArrayList<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "formation")
	private List<DemandeIntra> demandeIntras = new ArrayList<>();

	
}
