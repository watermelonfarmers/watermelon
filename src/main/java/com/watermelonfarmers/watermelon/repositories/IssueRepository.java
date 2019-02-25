package com.watermelonfarmers.watermelon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.watermelonfarmers.watermelon.entities.IssueEntity;

@Repository
public interface IssueRepository extends CrudRepository<IssueEntity, Long> {
}
