package com.example.demo.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "session")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_debut")
	private Date dateDebut;
	@Column(name = "date_fin")
	private Date dateFin;
	private Time duree;
	private String lieu;
	private String salle;
	private String formateur;
	private String support;
	private String autres;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "session")
	private List<UsersSession> usersSessions = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private Formation formation;
}
