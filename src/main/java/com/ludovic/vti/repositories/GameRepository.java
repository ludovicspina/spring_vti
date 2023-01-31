package com.ludovic.vti.repositories;

import com.ludovic.vti.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}

