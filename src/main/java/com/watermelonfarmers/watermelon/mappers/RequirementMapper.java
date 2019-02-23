package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.Requirement;

public class RequirementMapper {

    //For creat and update
    public static RequirementEntity mapRequirementToRequirementEntity(Requirement request) {
        RequirementEntity requirementEntity = new RequirementEntity();
        requirementEntity.setId(request.getId());
        requirementEntity.setTitle(request.getTitle());
        requirementEntity.setDescription(request.getDescription());
        requirementEntity.setCreated_by_user(request.getCreated_by_user());
        requirementEntity.setCreated_time(request.getCreated_time());
        requirementEntity.setLast_modified_time(request.getLast_modified_time());
        requirementEntity.setPriority(request.getPriority());
        requirementEntity.setStatus(request.getStatus());
//        requirementEntity.setActivities(request.getActivity());
//        requirementEntity.setCheck_list(request.getCheck_list());
//        requirementEntity.setComments(request.getComments());
        requirementEntity.setUrl(request.getUrl());
        requirementEntity.setArchived(request.getArchived());
        requirementEntity.setDue_date(request.getDue_date());
        return requirementEntity;
    }


    //For read
    public static Requirement mapRequirmentEntityToRequirement(RequirementEntity requirementEntity) {
        Requirement requirement = new Requirement();
        requirement.setId(requirementEntity.getId());
        requirement.setTitle(requirementEntity.getTitle());
        requirement.setDescription(requirementEntity.getDescription());
        requirement.setCreated_by_user(requirementEntity.getCreated_by_user());
        requirement.setCreated_time(requirementEntity.getCreated_time());
        requirement.setLast_modified_time(requirementEntity.getLast_modified_time());
        requirement.setPriority(requirementEntity.getPriority());
        requirement.setStatus(requirementEntity.getStatus());
//        requirement.setActivity(requirementEntity.getActivities());
//        requirement.setCheck_list(requirementEntity.getCheck_list());
//        requirement.setComments(requirementEntity.getComments());
        requirement.setUrl(requirementEntity.getUrl());
        requirement.setArchived(requirementEntity.getArchived());
        requirement.setDue_date(requirementEntity.getDue_date());
        return  requirement;
    }
}
