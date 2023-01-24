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
@Table(name = "session")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;
	@NonNull
	@Column(name = "date_debut")
	private LocalDate dateDebut;
	@NonNull
	@Column(name = "date_fin")
	private LocalDate dateFin;
	@NonNull
	private String lieu;
	@NonNull
	private String salle;
	@NonNull
	private String formateur;
	@NonNull
	private String support;
	@NonNull
	private String autres;

	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;
}
