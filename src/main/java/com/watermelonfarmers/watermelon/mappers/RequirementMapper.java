package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.models.requirements.RequirementIssueResponse;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class RequirementMapper {

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

        if (null != request.getRelatedIssueId()) {
            IssueEntity issue = new IssueEntity();
            issue.setIssueId(request.getRelatedIssueId());
            requirementEntity.setIssueEntity(issue);
        }

        if( null != request.getEstimatedTime()) {
            requirementEntity.setEstimatedTime(request.getEstimatedTime());
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

        if(null != requirementEntity.getArchived()) {
            requirement.setArchived(requirementEntity.getArchived());
        }

        if(null != requirementEntity.getStatus()) {
            requirement.setStatus(requirementEntity.getStatus());
        }

        if(null != requirementEntity.getDueDate()) {
            requirement.setDueDate(requirementEntity.getDueDate());
        }

        if(null != requirementEntity.getComments()) {
            List<CommentResponse> commentResponseList = new ArrayList<>();
            for (CommentEntity commentEntity : requirementEntity.getComments()) {
                CommentResponse commentResponse = CommentMapper.mapCommentEntityToCommentResponse(commentEntity);
                commentResponseList.add(commentResponse);
            }
            requirement.setComments(commentResponseList);
        }


        if(null != requirementEntity.getCreatedByUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getCreatedByUser());
            requirement.setCreatedByUser(user);
        }

        if(null != requirementEntity.getAssignedToUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(requirementEntity.getAssignedToUser());
            requirement.setAssignedToUser(user);
        }

        if(null != requirementEntity.getIssueEntity()) {
            RequirementIssueResponse issueResponse = new RequirementIssueResponse();
            issueResponse.setIssueId(requirementEntity.getIssueEntity().getIssueId());
            issueResponse.setTitle(requirementEntity.getIssueEntity().getTitle());
            requirement.setRelatedIssue(issueResponse);
        }

        if(null != requirementEntity.getEstimatedTime()) {
            requirement.setEstimatedTime(requirementEntity.getEstimatedTime());
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

        if (null != request.getRelatedIssueId()) {
            IssueEntity issue = new IssueEntity();
            issue.setIssueId(request.getRelatedIssueId());
            requirementEntity.setIssueEntity(issue);
        }

        if( null != request.getEstimatedTime()) {
            requirementEntity.setEstimatedTime(request.getEstimatedTime());
        }
        return requirementEntity;
    }

}
