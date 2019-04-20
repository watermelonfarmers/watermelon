package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.ActivityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityEntity, Long> {
    Iterable<ActivityEntity> findAllByProjectEntityProjectId(Long projectId);
}




