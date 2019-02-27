package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends CrudRepository<RequirementEntity, Long> {
}
