package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.entities.UserEntity;

public class UserMapper {

    public static User mapUserEntityToUser(UserEntity userEntity) {
        User user = new User();
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setUserName(userEntity.getUserName());
        return user;
    }

    public static UserEntity mapUserToUserEntity(User request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setUserName(request.getUserName());
        userEntity.setPassword(request.getPassword());

        return userEntity;
    }
}
