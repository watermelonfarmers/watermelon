package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    public static final String FIRST_NAME = "Arya";
    public static final String LAST_NAME = "Stark";
    public static final String USER_NAME = "user";
    public static final String PASSWORD = "password";

    private User user;

    private UserEntity userEntity;

    @Before
    public void setup() {
        this.user = new User();
        this.userEntity = new UserEntity();
    }

    @Test
    public void whenMapUserEntityToUserFirstNameShouldBeFirstName() {
        userEntity.setFirstName(FIRST_NAME);

        user = UserMapper.mapUserEntityToUser(userEntity);

        assertThat(user.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    public void whenMapUserEntityToUserLastNameShouldBeLastName() {
        userEntity.setLastName(LAST_NAME);

        user = UserMapper.mapUserEntityToUser(userEntity);

        assertThat(user.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    public void whenMapUserEntityToUserUserNameShouldBeUserName() {
        userEntity.setUserName(USER_NAME);

        user = UserMapper.mapUserEntityToUser(userEntity);

        assertThat(user.getUserName()).isEqualTo(USER_NAME);
    }

    @Test
    public void whenMapUserEntityToUserPasswordShouldBeNull() {
        userEntity.setPassword(PASSWORD);

        user = UserMapper.mapUserEntityToUser(userEntity);

        assertThat(user.getPassword()).isNull();
    }

    @Test
    public void whenMapUserToUserEntityFirstNameShouldBeFirstName() {
        user.setFirstName(FIRST_NAME);

        userEntity = UserMapper.mapUserToUserEntity(user);

        assertThat(userEntity.getFirstName()).isEqualTo(FIRST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityLastNameShouldBeLastName() {
        user.setLastName(LAST_NAME);

        userEntity = UserMapper.mapUserToUserEntity(user);

        assertThat(userEntity.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    public void whenMapUserToUserEntityUserNameShouldBeUserName() {
        user.setUserName(USER_NAME);

        userEntity = UserMapper.mapUserToUserEntity(user);

        assertThat(userEntity.getUserName()).isEqualTo(USER_NAME);
    }

    @Test
    public void whenMapUserToUserEntityPasswordShouldBePassword() {
        user.setPassword(PASSWORD);

        userEntity = UserMapper.mapUserToUserEntity(user);

        assertThat(userEntity.getPassword()).isEqualTo(PASSWORD);
    }


}