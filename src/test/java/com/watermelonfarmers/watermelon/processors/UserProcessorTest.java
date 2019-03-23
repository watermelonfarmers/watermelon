package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.models.users.UserRequest;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.users.UserResponse;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserProcessorTest {

    public static final String USER_NAME = "username";
    public static final String ORIGINAL = "Original";
    public static final String UPDATED = "Updated";

    private UserProcessor userProcessor;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntity userEntity;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Principal principal;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userProcessor = new UserProcessor(userRepository, passwordEncoder);
    }

    @Test
    public void whenCreateUserIsCalledUserIsCreatedAndResponseStatusCodeIsOK() {
        when(userRepository.save(any())).thenReturn(userEntity);

        ResponseEntity response = userProcessor.createUser(new UserRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenCreateUserIsCalledAndUserIdAlreadyExistsResponseStatusCodeIsConflict() {
        when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = userProcessor.createUser(new UserRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenCreateUserIsCalledAndUserIdAlreadyExistsResponseMessageIsAlreadyExists() {
        when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = userProcessor.createUser(new UserRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenGetUsersIsCalledAListOfUsersIsReturned() {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        when(userRepository.findAll()).thenReturn(userEntities);

        ResponseEntity<List<UserResponse>> response = userProcessor.getUsers();

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenGetUserByUserNameFindsAUserAUserIsReturned() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(USER_NAME);

        when(userRepository.findByUserName(USER_NAME)).thenReturn(userEntity);

        ResponseEntity<UserResponse> response = userProcessor.getUserByUserName(USER_NAME);

        assertThat(response.getBody().getUserName()).isEqualTo(USER_NAME);
    }

    @Test
    public void whenGetUserByUserNameDoesNotFindAUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(USER_NAME);

        when(userRepository.findByUserName(USER_NAME)).thenReturn(null);

        ResponseEntity<UserResponse> response = userProcessor.getUserByUserName(USER_NAME);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenUpdateUserIsCalledAndPrincipalUserIsNullUnauthorizedIsReturned() {
        UserRequest userRequest = new UserRequest();

        when(userRepository.save(any())).thenReturn(userEntity);

        ResponseEntity<UserResponse> response = userProcessor.updateUser(userRequest, null);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void whenUpdateUserIsCalledWithNewFirstNameFirstNameIsUpdated() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName(UPDATED);
        UserEntity userEntityOne = new UserEntity();

        when(principal.getName()).thenReturn(ORIGINAL);
        when(userRepository.findByUserName(ORIGINAL)).thenReturn(userEntityOne);

        ResponseEntity<UserResponse> response = userProcessor.updateUser(userRequest, principal);

        assertThat(response.getBody().getFirstName()).isEqualTo(UPDATED);
    }

    @Test
    public void whenUpdateUserIsAndFirstNameIsNullFirstNameIsOriginal() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName(null);
        UserEntity userEntityOne = new UserEntity();
        userEntityOne.setFirstName(ORIGINAL);

        when(principal.getName()).thenReturn(ORIGINAL);
        when(userRepository.findByUserName(ORIGINAL)).thenReturn(userEntityOne);

        ResponseEntity<UserResponse> response = userProcessor.updateUser(userRequest, principal);

        assertThat(response.getBody().getFirstName()).isEqualTo(ORIGINAL);
    }

    @Test
    public void whenUpdateUserIsCalledWithNewLastNameLastNameIsUpdated() {
        UserRequest userRequest = new UserRequest();
        userRequest.setLastName(UPDATED);
        UserEntity userEntityOne = new UserEntity();

        when(principal.getName()).thenReturn(ORIGINAL);
        when(userRepository.findByUserName(ORIGINAL)).thenReturn(userEntityOne);

        ResponseEntity<UserResponse> response = userProcessor.updateUser(userRequest, principal);

        assertThat(response.getBody().getLastName()).isEqualTo(UPDATED);
    }

    @Test
    public void whenUpdateUserIsAndLastNameIsNullLastNameIsOriginal() {
        UserRequest userRequest = new UserRequest();
        userRequest.setLastName(null);
        UserEntity userEntityOne = new UserEntity();
        userEntityOne.setLastName(ORIGINAL);

        when(principal.getName()).thenReturn(ORIGINAL);
        when(userRepository.findByUserName(ORIGINAL)).thenReturn(userEntityOne);

        ResponseEntity<UserResponse> response = userProcessor.updateUser(userRequest, principal);

        assertThat(response.getBody().getLastName()).isEqualTo(ORIGINAL);
    }

}