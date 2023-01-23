package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	List<Formation> findByNomFormation(String nomFormation);

	List<Formation> findByDomaine(String domaine);

	List<Formation> findByTheme(String theme);

	List<Formation> findByPrix(String prix);

}
