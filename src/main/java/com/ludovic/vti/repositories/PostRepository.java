package com.ludovic.vti.repositories;

import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
