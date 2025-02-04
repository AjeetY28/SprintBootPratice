package com.ajeet.prod_ready_features.prod_ready_features.repositories;

import com.ajeet.prod_ready_features.prod_ready_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
