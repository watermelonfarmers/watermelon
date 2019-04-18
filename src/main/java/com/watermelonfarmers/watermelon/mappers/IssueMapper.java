package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.issues.IssueRequest;
import com.watermelonfarmers.watermelon.models.issues.IssueRequirementResponse;
import com.watermelonfarmers.watermelon.models.issues.IssueResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class IssueMapper {

    public static IssueEntity mapIssueRequestToIssueEntity(IssueEntity issueEntity, IssueRequest request) {

        if (null != request.getTitle()) {
            issueEntity.setTitle(request.getTitle());
        }

        if (null != request.getDescription()) {
            issueEntity.setDescription(request.getDescription());
        }
        
        if (null != request.getSteps()) {
            issueEntity.setSteps(request.getSteps());
        }

        if (null != request.getPriority()) {
            issueEntity.setPriority(request.getPriority());
        }

        if (null != request.getStatus()) {
            issueEntity.setStatus(request.getStatus());
        }

        if (null != request.getEstimate()) {
            issueEntity.setEstimate(request.getEstimate());
        }

        if (null != request.getCreatedByUserId()) {
            UserEntity user = new UserEntity();
            user.setId(request.getCreatedByUserId());
            issueEntity.setCreatedByUser(user);
        }

        if (null != request.getAssignedUserId()) {
            UserEntity user = new UserEntity();
            user.setId(request.getAssignedUserId());
            issueEntity.setAssignedUser(user);
        }

        if (null != request.getProjectId()) {
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setProjectId(request.getProjectId());
            issueEntity.setProjectEntity(projectEntity);
        }

        return issueEntity;
    }


    public static IssueResponse mapIssueEntityToIssueResponse(IssueEntity issueEntity) {
        IssueResponse issue = new IssueResponse();

        if (null != issueEntity.getIssueId()) {
            issue.setIssueId(issueEntity.getIssueId());
        }

        if (null != issueEntity.getCreated()) {
            issue.setCreated(issueEntity.getCreated());
        }

        if (null != issueEntity.getLastModified()) {
            issue.setLastModified(issueEntity.getLastModified());
        }

        if (null != issueEntity.getTitle()) {
            issue.setTitle(issueEntity.getTitle());
        }

        if (null != issueEntity.getDescription()) {
            issue.setDescription(issueEntity.getDescription());
        }

        if (null != issueEntity.getPriority()) {
            issue.setPriority(issueEntity.getPriority());
        }

        if (null != issueEntity.getStatus()) {
            issue.setStatus(issueEntity.getStatus());
        }

        if (null != issueEntity.getEstimate()) {
            issue.setEstimate(issueEntity.getEstimate());
        }

        if (null != issueEntity.getCreatedByUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(issueEntity.getCreatedByUser());
            issue.setCreatedByUser(user);
        }

        if (null != issueEntity.getAssignedUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(issueEntity.getAssignedUser());
            issue.setAssignedUser(user);
        }

        if (null != issueEntity.getRequirementEntities()) {
            List<IssueRequirementResponse> requirementResponseList = new ArrayList<>();
            for (RequirementEntity requirement: issueEntity.getRequirementEntities()) {
                IssueRequirementResponse issueRequirement = new IssueRequirementResponse();
                issueRequirement.setRequirementId(requirement.getId());
                issueRequirement.setTitle(requirement.getTitle());
                requirementResponseList.add(issueRequirement);
            }
            issue.setRelatedRequirements(requirementResponseList);
        }

        return issue;
    }
}
