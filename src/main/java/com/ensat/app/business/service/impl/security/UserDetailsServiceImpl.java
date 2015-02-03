package com.ensat.app.business.service.impl.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensat.app.business.persistence.entities.Role;
import com.ensat.app.business.persistence.entities.Utilisateur;
import com.ensat.app.business.persistence.repositories.UtilisateurRepository;


@Service
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		// chercher l'utilisateur par son login dans la base en utilisant la couche persistence
		Utilisateur domainUser = utilisateurRepository.findByEmail(login);
		if (domainUser == null) {// si l'utilisateur n'existe pas on retourne une erreur
			throw new UsernameNotFoundException("L'utilisateur " + login + " est inéxistant!");
		}
		//Utilisateur domainUser = domainUserList.get(0);
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : domainUser.getRoles()) {
        	authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
		UserDetails userDetails = new User(
                domainUser.getLogin(), 
                domainUser.getPassword(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                authorities);
		return userDetails;
	}

}
