package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

public class RequirementMapper {

    //For creat
    public static RequirementEntity mapRequirementToRequirementEntity(RequirementRequest request) {
        RequirementEntity requirementEntity = new RequirementEntity();

        if(null != request.getTitle()) {
            requirementEntity.setTitle(request.getTitle());
        }

        if(null != request.getDescription()) {
            requirementEntity.setDescription(request.getDescription());
        }

        if(null != request.getPriority()) {
            requirementEntity.setPriority(request.getPriority());
        }

        if(null != request.getStatus()) {
            requirementEntity.setStatus(request.getStatus());
        }

        if(null != request.getIsArchived()) {
            requirementEntity.setIsArchived(request.getIsArchived());
        }

        if(null != request.getDueDate()) {
            requirementEntity.setDueDate(request.getDueDate());
        }

        if(null != request.getCreatedByUser()) {
            UserEntity user = new UserEntity();
            user.setId(request.getCreatedByUser());
            requirementEntity.setCreatedByUser(user);
        }

        if(null != request.getAssignedToUser()) {
            UserEntity user = new UserEntity();
            user.setId(request.getAssignedToUser());
            requirementEntity.setAssignedToUser(user);
        }

        return requirementEntity;
    }


    //For read
    public static RequirementResponse mapRequirementEntityToRequirement(RequirementEntity requirementEntity) {
        RequirementResponse requirement = new RequirementResponse();

        requirement.setId(requirementEntity.getId());

        if(null != requirementEntity.getTitle()) {
            requirement.setTitle(requirementEntity.getTitle());
        }

        if(null != requirementEntity.getDescription()) {
            requirement.setDescription(requirementEntity.getDescription());
        }

        if(null != requirementEntity.getCreatedTime()) {
            requirement.setCreatedTime(requirementEntity.getCreatedTime());
        }

        if(null != requirementEntity.getLastModifiedTime()) {
            requirement.setLastModifiedTime(requirementEntity.getLastModifiedTime());
        }

        if(null != requirementEntity.getPriority()) {
            requirement.setPriority(requirementEntity.getPriority());
        }

        if(null != requirementEntity.getIsArchived()) {
            requirement.setIsArchived(requirementEntity.getIsArchived());
        }

        if(null != requirementEntity.getStatus()) {
            requirement.setStatus(requirementEntity.getStatus());
        }

        if(null != requirementEntity.getDueDate()) {
            requirement.setDueDate(requirementEntity.getDueDate());
        }

        if(null != requirementEntity.getCreatedByUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getCreatedByUser());
            requirement.setCreatedByUser(user);
        }

        if(null != requirementEntity.getAssignedToUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getAssignedToUser());
            requirement.setAssignedToUser(user);
        }
        return  requirement;
    }

    //For update
    public static RequirementEntity mapRequirementToRequirementEntityForUpdate(RequirementEntity requirementEntity, RequirementRequest request) {

        if(null != request.getTitle()) {
            requirementEntity.setTitle(request.getTitle());
        }

        if(null != request.getDescription()) {
            requirementEntity.setDescription(request.getDescription());
        }

        if(null != request.getIsArchived()) {
            requirementEntity.setIsArchived(request.getIsArchived());
        }

        if(null != request.getCreatedByUser()) {
            UserEntity user = new UserEntity();
            user.setId(request.getCreatedByUser());
            requirementEntity.setCreatedByUser(user);
        }

        if(null != request.getAssignedToUser()) {
            UserEntity user = new UserEntity();
            user.setId(request.getAssignedToUser());
            requirementEntity.setAssignedToUser(user);
        }

        if(null != request.getDueDate()) {
            requirementEntity.setDueDate(request.getDueDate());
        }

        if(null != request.getPriority()) {
            requirementEntity.setPriority(request.getPriority());
        }

        if(null != request.getStatus()) {
            requirementEntity.setStatus(request.getStatus());
        }
        return requirementEntity;
    }

}
