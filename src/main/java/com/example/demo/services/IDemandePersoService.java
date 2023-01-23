package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.DemandePerso;

public interface IDemandePersoService extends IService<DemandePerso> {

	List<DemandePerso> findByEntreprise(String entreprise);

	List<DemandePerso> findByEligibleCPF(String eligibleCPF);

}
