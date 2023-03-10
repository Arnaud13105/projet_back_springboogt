package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DemandeIntra;
import com.example.demo.repository.DemandeIntraRepository;
import com.example.demo.repository.FormationRepository;
import com.example.demo.services.IDemandeIntraService;

@Service("demandeIntraService")
public class DemandeIntraServiceImpl implements IDemandeIntraService {

	@Autowired
	private DemandeIntraRepository demandeIntraRepository;

	@Autowired
	private FormationRepository formationRepository;

	public DemandeIntraServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DemandeIntra> findAll() {
		// TODO Auto-generated method stub
		return demandeIntraRepository.findAll();
	}

	@Override
	public DemandeIntra saveOrUpdate(DemandeIntra o) {
		// TODO Auto-generated method stub
		return demandeIntraRepository.save(o);
	}

	@Override
	public Optional<DemandeIntra> findById(long id) {
		// TODO Auto-generated method stub
		return demandeIntraRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		demandeIntraRepository.deleteById(id);
		;
		return true;
	}

	@Override
	public List<DemandeIntra> findByEntreprise(String entreprise) {
		// TODO Auto-generated method stub
		return demandeIntraRepository.findByEntreprise(entreprise);
	}

	@Override
	public List<DemandeIntra> findByEmail(String email) {
		// TODO Auto-generated method stub
		return demandeIntraRepository.findByEmail(email);
	}

	@Override
	public List<DemandeIntra> findByEligibleCPF(String eligibleCPF) {
		// TODO Auto-generated method stub
		return demandeIntraRepository.findByEligibleCPF(eligibleCPF);
	}

	@Override
	public Optional<DemandeIntra> getOneDemandeIntraByFormation(long idFormation, long idDemandeIntra) {
		return formationRepository.findById(idFormation).map(formation -> {
			DemandeIntra dIntra = demandeIntraRepository.findById(idDemandeIntra).get();
			return dIntra;
		});
	}

}
