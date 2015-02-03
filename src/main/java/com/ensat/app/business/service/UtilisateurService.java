package com.ensat.app.business.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ensat.app.business.persistence.entities.Utilisateur;

public interface UtilisateurService {
	
	public Utilisateur getUtilisateurByEmail(String email);
	
	public Utilisateur getUtilisateur(Long id);
	
	public Long ajouterUtilisateur(Utilisateur utilisateur);
	
	public Page<Utilisateur> pageUtilisateur(Pageable pageable);
	
}
