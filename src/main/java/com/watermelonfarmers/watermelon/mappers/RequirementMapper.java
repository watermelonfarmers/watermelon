package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.util.ArrayList;
import java.util.List;

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

        if(null != request.getArchived()) {
            requirementEntity.setArchived(request.getArchived());
        }

        if(null != request.getDue_date()) {
            requirementEntity.setDue_date(request.getDue_date());
        }

        if(null != request.getCreated_by_user()) {
            UserEntity user = new UserEntity();
            user.setId(request.getCreated_by_user());
            requirementEntity.setCreated_by_user(user);
        }

        if(null != request.getAssigned_to_user()) {
            UserEntity user = new UserEntity();
            user.setId(request.getAssigned_to_user());
            requirementEntity.setAssigned_to_user(user);
        }

//        Try to add a list of comment
//        for(CommentEntity commentEntity : request.getComments()) {
//            requirementEntity.addComment(commentEntity);
//        }
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

        if(null != requirementEntity.getCreated_time()) {
            requirement.setCreated_time(requirementEntity.getCreated_time());
        }

        if(null != requirementEntity.getLast_modified_time()) {
            requirement.setLast_modified_time(requirementEntity.getLast_modified_time());
        }

        if(null != requirementEntity.getPriority()) {
            requirement.setPriority(requirementEntity.getPriority());
        }

        if(null != requirementEntity.getArchived()) {
            requirement.setArchived(requirementEntity.getArchived());
        }

        if(null != requirementEntity.getStatus()) {
            requirement.setStatus(requirementEntity.getStatus());
        }

        if(null != requirementEntity.getDue_date()) {
            requirement.setDue_date(requirementEntity.getDue_date());
        }

        if(null != requirementEntity.getComments()) {
            List<CommentResponse> commentResponseList = new ArrayList<>();
            for (CommentEntity commentEntity: requirementEntity.getComments()) {
                CommentResponse commentResponse = CommentMapper.mapCommentEntityToCommentResponse(commentEntity);
                commentResponseList.add(commentResponse);
            }
            requirement.setComments(commentResponseList);
        }

        if(null != requirementEntity.getCreated_by_user()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getCreated_by_user());
            requirement.setCreated_by_user(user);
        }

        if(null != requirementEntity.getAssigned_to_user()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getAssigned_to_user());
            requirement.setAssigned_to_user(user);
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

        if(null != request.getArchived()) {
            requirementEntity.setArchived(request.getArchived());
        }

        if(null != request.getCreated_by_user()) {
            UserEntity user = new UserEntity();
            user.setId(request.getCreated_by_user());
            requirementEntity.setCreated_by_user(user);
        }

        if(null != request.getAssigned_to_user()) {
            UserEntity user = new UserEntity();
            user.setId(request.getAssigned_to_user());
            requirementEntity.setAssigned_to_user(user);
        }

        if(null != request.getDue_date()) {
            requirementEntity.setDue_date(request.getDue_date());
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
