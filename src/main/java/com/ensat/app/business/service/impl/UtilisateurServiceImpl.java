package com.ensat.app.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ensat.app.business.persistence.entities.Utilisateur;
import com.ensat.app.business.persistence.repositories.UtilisateurRepository;
import com.ensat.app.business.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Utilisateur getUtilisateurByEmail(String email) {		
		return utilisateurRepository.findByEmail(email);
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Long ajouterUtilisateur(Utilisateur utilisateur) {
		String password = utilisateur.getPassword();
		utilisateur.setPassword(passwordEncoder.encode(password));
		return utilisateurRepository.save(utilisateur).getId();
	}

	@Override
	public Page<Utilisateur> pageUtilisateur(Pageable pageable) {		
		return utilisateurRepository.findAll(pageable);
	}

}
