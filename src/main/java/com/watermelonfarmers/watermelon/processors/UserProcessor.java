package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.mappers.UserMapper;
import com.watermelonfarmers.watermelon.models.users.UserRequest;
import com.watermelonfarmers.watermelon.models.users.UserResponse;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public ResponseEntity<List<UserResponse>> getUsers() {

        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserResponse> userRequests = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            UserResponse userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);
            userRequests.add(userResponse);
        }

        return new ResponseEntity<>(userRequests, HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> getUserByUserName(String userName) {

        ResponseEntity<UserResponse> response;
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (null == userEntity) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            UserResponse userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);
            response = new ResponseEntity<>(userResponse, HttpStatus.OK);
        }

        return response;
    }

    public ResponseEntity createUser(UserRequest request) {

        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);

        UserEntity userEntity = UserMapper.mapUserToUserEntity(request);

        try {
            String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
            userEntity.setPassword(encodedPassword);
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return response;
    }

    public ResponseEntity<UserResponse> updateUser(UserRequest request, Principal user) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserEntity userEntity = userRepository.findByUserName(user.getName());
        UserMapper.mapUserToUserEntityForUpdate(userEntity, request);
        if (null != request.getPassword()) {
            String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
            userEntity.setPassword(encodedPassword);
        }
        userRepository.save(userEntity);
        UserResponse updatedUser = UserMapper.mapUserEntityToUserResponse(userEntity);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
