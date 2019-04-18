package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequirementRepository extends CrudRepository<RequirementEntity, Long> {
    Iterable<RequirementEntity> findAllByProjectEntityProjectId(Long projectId);
}
