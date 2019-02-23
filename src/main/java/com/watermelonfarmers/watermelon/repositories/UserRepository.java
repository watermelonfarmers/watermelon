package com.watermelonfarmers.watermelon.repositories;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);
}
