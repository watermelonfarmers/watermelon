package com.watermelonfarmers.watermelon.models.issues;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

public class IssueResponse {

    private Long issueId;
    private LocalDateTime created;
    private LocalDateTime lastModified;
    private String title;
    private String description;
    private String steps;
    private Integer priority;
    private String status;
    private Long estimate;
    private UserResponse createdByUser;
    private UserResponse assignedUser;
    private List<IssueRequirementResponse> relatedRequirements;
    private List<CommentResponse> comments;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserResponse getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserResponse createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserResponse getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(UserResponse assignedUser) {
        this.assignedUser = assignedUser;
    }

    public List<IssueRequirementResponse> getRelatedRequirements() {
        return relatedRequirements;
    }

    public void setRelatedRequirements(List<IssueRequirementResponse> relatedRequirements) {
        this.relatedRequirements = relatedRequirements;
    }

    public Long getEstimate() {
        return estimate;
    }

    public void setEstimate(Long estimate) {
        this.estimate = estimate;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }
}
