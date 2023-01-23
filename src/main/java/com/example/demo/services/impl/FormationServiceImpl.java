package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Formation;
import com.example.demo.repository.FormationRepository;
import com.example.demo.services.IFormationService;

@Service("formationService")
public class FormationServiceImpl implements IFormationService{
	
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		
		return formationRepository.findAll();
	}

	@Override
	public Formation saveOrUpdate(Formation o) {

		return formationRepository.save(o);
	}

	@Override
	public Optional<Formation> findById(long id) {
		// TODO Auto-generated method stub
		return formationRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		formationRepository.deleteById(id);		
		return true;
	}

	@Override
	public List<Formation> findByNomFormation(String nomFormation) {
		// TODO Auto-generated method stub
		return formationRepository.findByNomFormation(nomFormation);
	}

	@Override
	public List<Formation> findByDomaine(String domaine) {
		// TODO Auto-generated method stub
		return formationRepository.findByDomaine(domaine);
	}

	@Override
	public List<Formation> findByTheme(String theme) {
		// TODO Auto-generated method stub
		return formationRepository.findByTheme(theme);
	}

	@Override
	public List<Formation> findByPrix(String prix) {
		// TODO Auto-generated method stub
		return formationRepository.findByPrix(prix);
	}


	
}



