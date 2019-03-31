package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByChannelEntityChannelId(long channelId);
}
