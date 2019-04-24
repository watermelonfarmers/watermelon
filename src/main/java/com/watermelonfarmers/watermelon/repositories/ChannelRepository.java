package com.watermelonfarmers.watermelon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;

@Repository
public interface ChannelRepository extends CrudRepository<ChannelEntity, Long> {
    Iterable<ChannelEntity> findAllByProjectEntityProjectId(long projectId);
}
