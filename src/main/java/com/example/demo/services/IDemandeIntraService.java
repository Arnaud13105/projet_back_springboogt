package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.DemandeIntra;

public interface IDemandeIntraService extends IService<DemandeIntra> {

	List<DemandeIntra> findByEntreprise(String entreprise);

	List<DemandeIntra> findByEmail(String email);

	List<DemandeIntra> findByEligibleCPF(String eligibleCPF);

	Optional<DemandeIntra> saveOneDemandeIntraByFormation(long idFormation, DemandeIntra demandeIntra);

	Optional<DemandeIntra> getOneDemandeIntraByFormationId(long idFormation, long idDemandeIntra);

	Optional<DemandeIntra> assignOneDemandeIntraByFormation(long idFormation, long idDemandeIntra);

	Optional<DemandeIntra> deleteOneDemandeIntraByFormationId(long idFormation, long idDemandeIntra);

	Optional<DemandeIntra> editOneDemandeIntraByFormation(long idFormation, long idDemandeIntra,
			DemandeIntra demandeIntra);

}
