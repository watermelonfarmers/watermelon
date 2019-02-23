package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.User;

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

    public static UserEntity mapUserToUserEntityForUpdate(UserEntity userEntity, User request) {

        if (null != request.getFirstName()) {
            userEntity.setFirstName(request.getFirstName());
        }

        if (null != request.getLastName()) {
            userEntity.setLastName(request.getLastName());
        }

        if (null != request.getPassword()) {
            userEntity.setPassword(request.getPassword());
        }
        return userEntity;
    }
}
