package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ActivityEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.Activity.ActivityRequest;
import com.watermelonfarmers.watermelon.models.Activity.ActivityResponse;

public class ActivityMapper {
    public static ActivityEntity mapActivityRequestToActivityEntity(ActivityRequest activityRequest) {
        ActivityEntity activityEntity = new ActivityEntity();
        if(null != activityRequest.getCreatedUserId()) {
            UserEntity user = new UserEntity();
            user.setId(activityRequest.getCreatedUserId());
            activityEntity.setUser(user);
        }

        if(null != activityRequest.getAction()) {
            activityEntity.setAction(activityRequest.getAction());
        }

        if(null != activityRequest.getTarget()) {
            activityEntity.setTarget(activityRequest.getTarget());
        }

        if(null != activityRequest.getStartPoint()) {
            activityEntity.setStartPoint(activityRequest.getStartPoint());
        }

        if(null != activityRequest.getEndPoint()) {
            activityEntity.setEndPoint(activityRequest.getEndPoint());
        }

        return activityEntity;
    }

    public static ActivityResponse mapActivityEntityToActivityResponse(ActivityEntity activityEntity) {
        ActivityResponse activityResponse = new ActivityResponse();

        if(null != activityEntity.getUser()) {
            activityResponse.setUser(UserMapper.mapUserEntityToUserResponse(activityEntity.getUser()));
        }

        if(null != activityEntity.getCreatedTime()) {
            activityResponse.setCreatedTime(activityEntity.getCreatedTime());
        }

        String activityBuild = activityEntity.getUser().getFirstName() + " " + activityEntity.getAction() + " " + activityEntity.getTarget() + " " + activityEntity.getStartPoint() + " " + activityEntity.getEndPoint();

        activityResponse.setActivity(activityBuild);

        return activityResponse;
    }
}



