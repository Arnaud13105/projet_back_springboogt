package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userSessionId")
public class UserSessionId implements Serializable {

	private Long idUser;
	private Long idSession;

}
