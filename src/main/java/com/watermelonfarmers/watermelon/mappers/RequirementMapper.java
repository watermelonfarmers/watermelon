package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.Requirement;

public class RequirementMapper {

    //For creat
    public static RequirementEntity mapRequirementToRequirementEntity(Requirement request) {
        RequirementEntity requirementEntity = new RequirementEntity();
        /**
         * RequirementEntity should generate id by database, but we cannot setId in requirementEntity
         */
//        requirementEntity.setId(request.getId());
        requirementEntity.setTitle(request.getTitle());
        requirementEntity.setDescription(request.getDescription());
        requirementEntity.setCreated_by_user(request.getCreated_by_user());
        requirementEntity.setCreated_time(request.getCreated_time());
        requirementEntity.setLast_modified_time(request.getLast_modified_time());
        requirementEntity.setPriority(request.getPriority());
        requirementEntity.setStatus(request.getStatus());
        requirementEntity.setUrl(request.getUrl());
        requirementEntity.setArchived(request.getArchived());
        requirementEntity.setDue_date(request.getDue_date());
        requirementEntity.setAssigned_to(request.getAssigned_to());

//        Try to add a list of comment
//        for(CommentEntity commentEntity : request.getComments()) {
//            requirementEntity.addComment(commentEntity);
//        }
        return requirementEntity;
    }


    //For read
    public static Requirement mapRequirementEntityToRequirement(RequirementEntity requirementEntity) {
        Requirement requirement = new Requirement();
        requirement.setId(requirementEntity.getId());
        requirement.setTitle(requirementEntity.getTitle());
        requirement.setDescription(requirementEntity.getDescription());
        requirement.setCreated_by_user(requirementEntity.getCreated_by_user());
        requirement.setCreated_time(requirementEntity.getCreated_time());
        requirement.setLast_modified_time(requirementEntity.getLast_modified_time());
        requirement.setPriority(requirementEntity.getPriority());
        requirement.setStatus(requirementEntity.getStatus());
        requirement.setUrl(requirementEntity.getUrl());
        requirement.setArchived(requirementEntity.getArchived());
        requirement.setDue_date(requirementEntity.getDue_date());
        requirement.setAssigned_to(requirementEntity.getAssigned_to());

        //Try to add a list of comment
        requirement.setComments(requirementEntity.getComments());
        return  requirement;
    }

    //For update
    public static RequirementEntity mapRequirementToRequirementEntityForUpdate(RequirementEntity requirementEntity, Requirement request) {

        if(null != request.getTitle()) {
            requirementEntity.setTitle(request.getTitle());
        }

        if(null != request.getDescription()) {
            requirementEntity.setDescription(request.getDescription());
        }

        if(null != request.getArchived()) {
            requirementEntity.setArchived(request.getArchived());
        }

        if(null != request.getAssigned_to()) {
            requirementEntity.setAssigned_to(request.getAssigned_to());
        }

        if(null != request.getCreated_by_user()) {
            requirementEntity.setCreated_by_user(request.getCreated_by_user());
        }

        if(null != request.getDue_date()) {
            requirementEntity.setDue_date(request.getDue_date());
        }

        if(null != request.getPriority()) {
            requirementEntity.setPriority(request.getPriority());
        }

        if(null != request.getLast_modified_time()) {
            requirementEntity.setLast_modified_time(request.getLast_modified_time());
        }

        if(null != request.getUrl()) {
            requirementEntity.setUrl(request.getUrl());
        }

        if(null != request.getStatus()) {
            requirementEntity.setStatus(request.getStatus());
        }
        return requirementEntity;
    }

}
