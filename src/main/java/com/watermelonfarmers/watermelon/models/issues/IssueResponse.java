package com.watermelonfarmers.watermelon.models.issues;

import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.time.LocalDateTime;

public class IssueResponse {

    private Long issueId;
    private LocalDateTime created;
    private LocalDateTime last_modified;
    private String title;
    private String description;
    private Integer priority;
    private String status;
    private UserResponse createdByUser;
    private UserResponse assignedUser;

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

    public LocalDateTime getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(LocalDateTime last_modified) {
        this.last_modified = last_modified;
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
}
