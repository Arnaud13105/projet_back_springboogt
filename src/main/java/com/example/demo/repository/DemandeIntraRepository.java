package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.DemandeIntra;

public interface DemandeIntraRepository extends JpaRepository<DemandeIntra, Long> {

	List<DemandeIntra> findByEntreprise(String entreprise);

	List<DemandeIntra> findByEmail(String email);

	List<DemandeIntra> findByEligibleCPF(String eligibleCPF);

	List<DemandeIntra> findDemandeIntraByFormationId(long idFormation) ;

}
