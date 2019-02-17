package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.mappers.UserMapper;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProcessor {

    private UserRepository userRepository;

    @Autowired
    public UserProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getUsers() {

        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = UserMapper.mapUserEntityToUser(userEntity);
            users.add(user);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity createUser(User request) {

        ResponseEntity response = new ResponseEntity("success", HttpStatus.OK);

        UserEntity userEntity = UserMapper.mapUserToUserEntity(request);

        try {
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity("already exists",HttpStatus.CONFLICT);
        }

        return response;
    }

}
