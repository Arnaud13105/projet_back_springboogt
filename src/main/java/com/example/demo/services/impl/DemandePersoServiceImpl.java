package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DemandePerso;
import com.example.demo.repository.DemandePersoRepository;
import com.example.demo.services.IDemandePersoService;

@Service("demandePersoService")
public class DemandePersoServiceImpl implements IDemandePersoService {

	@Autowired
	private DemandePersoRepository demandePersoRepository;

	@Override
	public List<DemandePerso> findAll() {
		// TODO Auto-generated method stub
		return demandePersoRepository.findAll();
	}

	@Override
	public DemandePerso saveOrUpdate(DemandePerso o) {
		// TODO Auto-generated method stub
		return demandePersoRepository.save(o);
	}

	@Override
	public Optional<DemandePerso> findById(long id) {
		// TODO Auto-generated method stub
		return demandePersoRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		demandePersoRepository.deleteById(id);
		return true;
	}

	@Override
	public List<DemandePerso> findByEntreprise(String entreprise) {
		// TODO Auto-generated method stub
		return demandePersoRepository.findByEntreprise(entreprise);
	}

	@Override
	public List<DemandePerso> findByEligibleCPF(String eligibleCPF) {
		// TODO Auto-generated method stub
		return demandePersoRepository.findByEligibleCPF(eligibleCPF);
	}

}
