package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.users.UserRequest;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

public class UserMapper {

    public static UserResponse mapUserEntityToUserResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userEntity.getId());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setUserName(userEntity.getUserName());
        return userResponse;
    }

    public static UserEntity mapUserToUserEntity(UserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setUserName(request.getUserName());
        userEntity.setPassword(request.getPassword());

        return userEntity;
    }

    public static UserEntity mapUserToUserEntityForUpdate(UserEntity userEntity, UserRequest request) {

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
