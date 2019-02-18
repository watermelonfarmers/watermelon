package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.Requirement;

public class RequirementMapper {

    public static RequirementEntity mapRequirementToRequirementEntity(Requirement request) {
        RequirementEntity requirementEntity = new RequirementEntity();
        requirementEntity.setId(request.getId());
        requirementEntity.setTitle(request.getTitle());
        requirementEntity.setDescription(request.getDescription());
        requirementEntity.setCreated_by_user(request.getCreated_by_user());
        requirementEntity.setCreated(request.getCreated());
        requirementEntity.setLast_modified(request.getLast_modified());
        requirementEntity.setPriority(request.getPriority());
        requirementEntity.setStatus(request.getStatus());
        return requirementEntity;
    }
}
