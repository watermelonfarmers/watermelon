package com.watermelonfarmers.watermelon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.watermelonfarmers.watermelon.entities.MessageEntity;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
}
