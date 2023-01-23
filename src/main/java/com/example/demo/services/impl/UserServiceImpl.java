package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.IUserService;

@Service("user")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User saveOrUpdate(User o) {
		// TODO Auto-generated method stub
		return userRepository.save(o);
	}

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

		return true;

	}

	@Override
	public List<User> findByNom(String nom) {
		// TODO Auto-generated method stub
		return userRepository.findByNom(nom);
	}

	@Override
	public List<User> findByPrenom(String prenom) {
		// TODO Auto-generated method stub
		return userRepository.findByPrenom(prenom);
	}

	@Override
	public List<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByEntreprise(String entreprise) {
		// TODO Auto-generated method stub
		return userRepository.findByEntreprise(entreprise);
	}

	@Override
	public List<User> findByStatut(String statut) {
		// TODO Auto-generated method stub
		return userRepository.findByStatut(statut);
	}

}
