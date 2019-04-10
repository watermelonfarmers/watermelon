package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.users.UserRequest;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserMapper {

    private static final String GRAVATAR_URL = "http://www.gravatar.com/avatar/";
    private static final String DEFAULT_OPTION = "?d=retro";

    public static UserResponse mapUserEntityToUserResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userEntity.getId());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setAvatarUrl(getAvatarUrl(userEntity));
        return userResponse;
    }

    public static UserEntity mapUserToUserEntity(UserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setUserName(request.getUserName());
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
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

        if (null != request.getEmail()) {
            userEntity.setEmail(request.getEmail());
        }
        return userEntity;
    }

    private static String getAvatarUrl(UserEntity userEntity) {
        String avatarUrl = GRAVATAR_URL;
        try {
            if (null != userEntity.getEmail()) {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(userEntity.getEmail().getBytes());
                byte[] digest = messageDigest.digest();
                String emailHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

                avatarUrl += emailHash;
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        avatarUrl += DEFAULT_OPTION;

        return avatarUrl;
    }
}
