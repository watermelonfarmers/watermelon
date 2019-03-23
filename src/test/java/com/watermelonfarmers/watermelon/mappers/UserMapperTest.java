package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.models.users.UserRequest;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.users.UserResponse;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    public static final String FIRST_NAME = "Arya";
    public static final String LAST_NAME = "Stark";
    public static final String USER_NAME = "userRequest";
    public static final String PASSWORD = "password";
    public static final String ORIGINAL_VALUE = "ORIGINAL";

    private UserRequest userRequest;
    private UserResponse userResponse;
    private UserEntity userEntity;

    @Before
    public void setup() {
        this.userRequest = new UserRequest();
        this.userResponse = new UserResponse();
        this.userEntity = new UserEntity();
    }

    @Test
    public void whenMapUserEntityToUserUserIdShouldBeUserId() {
        userEntity.setId(15);

        userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);

        assertThat(userResponse.getUserId()).isEqualTo(15);
    }

    @Test
    public void whenMapUserEntityToUserFirstNameShouldBeFirstName() {
        userEntity.setFirstName(FIRST_NAME);

        userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);

        assertThat(userResponse.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    public void whenMapUserEntityToUserLastNameShouldBeLastName() {
        userEntity.setLastName(LAST_NAME);

        userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);

        assertThat(userResponse.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    public void whenMapUserEntityToUserUserNameShouldBeUserName() {
        userEntity.setUserName(USER_NAME);

        userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);

        assertThat(userResponse.getUserName()).isEqualTo(USER_NAME);
    }

    @Test
    public void whenMapUserEntityToUserPasswordShouldBeNull() {
        userEntity.setPassword(PASSWORD);

        userResponse = UserMapper.mapUserEntityToUserResponse(userEntity);

        assertThat(userRequest.getPassword()).isNull();
    }

    @Test
    public void whenMapUserToUserEntityFirstNameShouldBeFirstName() {
        userRequest.setFirstName(FIRST_NAME);

        userEntity = UserMapper.mapUserToUserEntity(userRequest);

        assertThat(userEntity.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityLastNameShouldBeLastName() {
        userRequest.setLastName(LAST_NAME);

        userEntity = UserMapper.mapUserToUserEntity(userRequest);

        assertThat(userEntity.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityUserNameShouldBeUserName() {
        userRequest.setUserName(USER_NAME);

        userEntity = UserMapper.mapUserToUserEntity(userRequest);

        assertThat(userEntity.getUserName()).isEqualTo(USER_NAME);
    }

    @Test
    public void whenMapUserToUserEntityPasswordShouldBePassword() {
        userRequest.setPassword(PASSWORD);

        userEntity = UserMapper.mapUserToUserEntity(userRequest);

        assertThat(userEntity.getPassword()).isEqualTo(PASSWORD);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateFirstNameShouldBeFirstName() {
        userRequest.setFirstName(FIRST_NAME);
        userEntity.setFirstName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateLastNameShouldBeLastName() {
        userRequest.setLastName(LAST_NAME);
        userEntity.setLastName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateUserNameShouldBeOriginalUserName() {
        userRequest.setUserName(USER_NAME);
        userEntity.setUserName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getUserName()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapUserToUserEntityForUpdatePasswordShouldBePassword() {
        userRequest.setPassword(PASSWORD);
        userEntity.setPassword(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getPassword()).isEqualTo(PASSWORD);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateAndPasswordIsNullPasswordShouldBeOriginal() {
        userRequest.setPassword(null);
        userEntity.setPassword(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getPassword()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateAndFirstNameIsNullFirstNameShouldBeOriginal() {
        userRequest.setFirstName(null);
        userEntity.setFirstName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getFirstName()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateAndLastNameIsNullLastNameShouldBeOriginal() {
        userRequest.setLastName(null);
        userEntity.setLastName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getLastName()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapUserToUserEntityForUpdateAndUserNameIsNotNullUserNameShouldStayOriginal() {
        userRequest.setUserName(USER_NAME);
        userEntity.setUserName(ORIGINAL_VALUE);

        userEntity = UserMapper.mapUserToUserEntityForUpdate(userEntity, userRequest);

        assertThat(userEntity.getUserName()).isEqualTo(ORIGINAL_VALUE);
    }


}