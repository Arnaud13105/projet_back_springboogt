package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@IdClass(UserSessionId.class)
public class UserSession {

	@Id
	private Long idUser;

	@Id
	private Long idSession;

}