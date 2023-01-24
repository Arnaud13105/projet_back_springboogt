package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Formation;

public interface IFormationService extends IService<Formation> {

	List<Formation> findByNomFormation(String nomFormation);

	List<Formation> findByDomaine(String domaine);

	List<Formation> findByTheme(String theme);

	List<Formation> findByPrix(String prix);

}
