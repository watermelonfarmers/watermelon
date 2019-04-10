package com.watermelonfarmers.watermelon.models.requirements;

import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

public class RequirementResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;
    private String priority;
    private String status;
    private LocalDateTime dueDate;
    private Boolean isArchived;
    private List<CommentResponse> comments;
    private UserResponse createdByUser;
    private UserResponse assignedToUser;
    private RequirementIssueResponse relatedIssue;

    public RequirementResponse() {
    }

    public RequirementResponse(Long id, String title, String description, LocalDateTime createdTime, LocalDateTime lastModifiedTime, String priority, String status, LocalDateTime dueDate, Boolean isArchived, List<CommentResponse> comments, UserResponse createdByUser, UserResponse assignedToUser, RequirementIssueResponse relatedIssue) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.lastModifiedTime = lastModifiedTime;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.isArchived = isArchived;
        this.comments = comments;
        this.createdByUser = createdByUser;
        this.assignedToUser = assignedToUser;
        this.relatedIssue = relatedIssue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }

    public UserResponse getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserResponse createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserResponse getAssignedToUser() {
        return assignedToUser;
    }

    public void setAssignedToUser(UserResponse assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    public RequirementIssueResponse getRelatedIssue() {
        return relatedIssue;
    }

    public void setRelatedIssue(RequirementIssueResponse relatedIssue) {
        this.relatedIssue = relatedIssue;
    }
}
