package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}






