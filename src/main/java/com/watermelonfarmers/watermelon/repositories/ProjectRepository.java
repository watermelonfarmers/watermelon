package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
}
