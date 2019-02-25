package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.models.Issue;

public class IssueMapper {
    public static IssueEntity mapIssueEntityToIssue(Issue request) {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setId(request.getId());
        issueEntity.setTitle(request.getTitle());
        issueEntity.setDescription(request.getDescription());
        issueEntity.setPriority(request.getPriority());
        issueEntity.setStatus(request.getStatus());
        issueEntity.setCreated_by_user_id(request.getCreated_by_user_id());
        issueEntity.setCreated(request.getCreated());
        issueEntity.setLast_modified(request.getLast_modified());
        return issueEntity;
    }

    public static Issue mapIssueToIssueEntity(IssueEntity issueEntity) {
        Issue issue = new Issue();
        issue.setId(issueEntity.getId());
        issue.setTitle(issueEntity.getTitle());
        issue.setDescription(issueEntity.getDescription());
        issue.setPriority(issueEntity.getPriority());
        issue.setStatus(issueEntity.getStatus());
        issue.setCreated_by_user_id(issueEntity.getCreated_by_user_id());
        issue.setCreated(issueEntity.getCreated());
        issue.setLast_modified(issueEntity.getLast_modified());
        return issue;
    }
}
