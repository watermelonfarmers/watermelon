package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.models.User;

public class RequirementMapper {

//    public static UserEntity mapUserToUserEntity(User request) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName(request.getFirstName());
//        userEntity.setLastName(request.getLastName());
//        userEntity.setUserName(request.getUserName());
//        userEntity.setPassword(request.getPassword());
//
//        return userEntity;
//    }


    public static RequirementEntity mapRequirementToRequirementEntity(Requirement request) {
        RequirementEntity requirementEntity = new RequirementEntity();
        requirementEntity.setId(request.getId());
        return requirementEntity;
    }
}
