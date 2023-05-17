package com.ludovic.vti.repositories;

import com.ludovic.vti.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByLabel(String admin);

}

