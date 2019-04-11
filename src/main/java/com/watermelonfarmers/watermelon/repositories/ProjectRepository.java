package com.watermelonfarmers.watermelon.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findAllByProjectEntityProjectId(long channelId);
}
