package com.watermelonfarmers.watermelon.models.requirements;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;
import java.time.LocalDateTime;
import java.util.List;

public class RequirementResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime created_time;
    private LocalDateTime last_modified_time;
    private Integer priority;
    private String status;
    private LocalDateTime due_date;
    private Boolean isArchived;
    private List<CommentResponse> comments;
    private UserResponse created_by_user;
    private UserResponse assigned_to_user;

    public RequirementResponse() {
    }

    public RequirementResponse(Long id, String title, String description, LocalDateTime created_time, LocalDateTime last_modified_time, Integer priority, String status, LocalDateTime due_date, Boolean isArchived, List<CommentResponse> comments, UserResponse created_by_user, UserResponse assigned_to_user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created_time = created_time;
        this.last_modified_time = last_modified_time;
        this.priority = priority;
        this.status = status;
        this.due_date = due_date;
        this.isArchived = isArchived;
        this.comments = comments;
        this.created_by_user = created_by_user;
        this.assigned_to_user = assigned_to_user;
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

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(LocalDateTime last_modified_time) {
        this.last_modified_time = last_modified_time;
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

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
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

    public UserResponse getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(UserResponse created_by_user) {
        this.created_by_user = created_by_user;
    }

    public UserResponse getAssigned_to_user() {
        return assigned_to_user;
    }

    public void setAssigned_to_user(UserResponse assigned_to_user) {
        this.assigned_to_user = assigned_to_user;
    }
}
