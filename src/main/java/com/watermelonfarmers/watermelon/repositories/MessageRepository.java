package com.watermelonfarmers.watermelon.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.watermelonfarmers.watermelon.entities.MessageEntity;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    @Query(value = "select a.* from MESSAGE a, CHANNEL b where a.channel_id=b.id and b.id=?1", nativeQuery = true)
    List<MessageEntity> findAllMessagesByChannelId(long channelId);
}
