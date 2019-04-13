package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<IssueEntity, Long> {

    Iterable<IssueEntity> findAllByProjectEntityProjectId(long channelId);
}
