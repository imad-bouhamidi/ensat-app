package com.ensat.app.business.persistence.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ensat.app.business.persistence.entities.Utilisateur;

public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
	
	public Utilisateur findByEmail(String email);

}
