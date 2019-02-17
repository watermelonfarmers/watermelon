package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserProcessorTest {

    public static final String ALREADY_EXISTS = "already exists";

    private UserProcessor userProcessor;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntity userEntity;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userProcessor = new UserProcessor(userRepository);
    }

    @Test
    public void whenCreateUserIsCalledUserIsCreatedAndResponseStatusCodeIsOK() {
        when(userRepository.save(any())).thenReturn(userEntity);

        ResponseEntity response = userProcessor.createUser(new User());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenCreateUserIsCalledAndUserIdAlreadyExistsResponseStatusCodeIsConflict() {
        when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = userProcessor.createUser(new User());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenCreateUserIsCalledAndUserIdAlreadyExistsResponseMessageIsAlreadyExists() {
        when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = userProcessor.createUser(new User());

        assertThat(response.getBody()).isEqualTo(ALREADY_EXISTS);
    }

    @Test
    public void whenGetUsersIsCalledAListOfUsersIsReturned() {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        when(userRepository.findAll()).thenReturn(userEntities);

        ResponseEntity<List<User>> response = userProcessor.getUsers();

        assertThat(response.getBody().size()).isEqualTo(2);
    }

}