package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersSession")
public class UsersSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
