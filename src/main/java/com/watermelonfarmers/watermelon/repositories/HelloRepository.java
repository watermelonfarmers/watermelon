package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.HelloEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository<HelloEntity, Long> {

}
