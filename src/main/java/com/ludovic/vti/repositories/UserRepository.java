package com.ludovic.vti.repositories;

import com.ludovic.vti.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
