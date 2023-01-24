package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.DemandePerso;

public interface DemandePersoRepository extends JpaRepository<DemandePerso, Long> {

	List<DemandePerso> findByEntreprise(String entreprise);

	List<DemandePerso> findByEligibleCPF(String eligibleCPF);

}
