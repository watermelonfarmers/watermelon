package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.mappers.UserMapper;
import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserProcessor {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserProcessor(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public ResponseEntity<User> getUserByUserName(String userName) {

        ResponseEntity<User> response;
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (null == userEntity) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            User user = UserMapper.mapUserEntityToUser(userEntity);
            response = new ResponseEntity<>(user, HttpStatus.OK);
        }

        return response;
    }

    public ResponseEntity createUser(User request) {

        ResponseEntity response = new ResponseEntity<>("success", HttpStatus.OK);

        UserEntity userEntity = UserMapper.mapUserToUserEntity(request);

        try {
            String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
            userEntity.setPassword(encodedPassword);
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity<>("already exists",HttpStatus.CONFLICT);
        }

        return response;
    }

    public ResponseEntity<User> updateUser(User request, Principal user) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserEntity userEntity = userRepository.findByUserName(user.getName());
        UserMapper.mapUserToUserEntityForUpdate(userEntity, request);
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);
        userRepository.save(userEntity);
        User updatedUser = UserMapper.mapUserEntityToUser(userEntity);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
