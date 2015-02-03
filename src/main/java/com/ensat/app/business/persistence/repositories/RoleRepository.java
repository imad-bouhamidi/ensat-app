package com.ensat.app.business.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensat.app.business.persistence.entities.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
