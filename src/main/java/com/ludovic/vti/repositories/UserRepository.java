package com.ludovic.vti.repositories;

import com.ludovic.vti.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository<User> extends CrudRepository<com.ludovic.vti.models.User, Integer> {

}