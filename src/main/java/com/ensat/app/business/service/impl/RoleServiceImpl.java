package com.ensat.app.business.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.app.business.persistence.entities.Role;
import com.ensat.app.business.persistence.repositories.RoleRepository;
import com.ensat.app.business.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role getRole(Long id) {
		return roleRepository.findOne(id);
	}

}
