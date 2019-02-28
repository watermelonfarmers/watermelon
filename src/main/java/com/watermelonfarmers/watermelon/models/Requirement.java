package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Requirement {

    @ApiModelProperty(value = "title", example = "Add requirement API to watermelon service")
    private String title;

    @ApiModelProperty(value = "description", example = "This is very important")
    private String description;


    @ApiModelProperty(value = "created_time", example = "2019-02-18T20:53:58")
    private LocalDateTime created_time;

    @ApiModelProperty(value = "last_modified_time", example = "2019-02-18T20:53:58")
    private LocalDateTime last_modified_time;


    @ApiModelProperty(value = "priority", example = "10")
    private Integer priority;

    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;

    @ApiModelProperty(value = "created_by_user", example = "Hannibal")
    private String created_by_user;

    @ApiModelProperty(value = "due_date", example = "2019-02-18T20:53:58")
    private LocalDateTime due_date;

    @ApiModelProperty(value = "isArchived", example = "False")
    private Boolean isArchived;

//    @ApiModelProperty(value = "comments", example = "Nice job!")
    private List<CommentEntity> comments;

    @ApiModelProperty(value = "url", example = "https://www.pivotaltracker.com/story/show/164053311")
    private String url;


    @ApiModelProperty(value = "assigned_to", example = "Arya")
    private String assigned_to;

    public Requirement() {
    }

    public Requirement(String title, String description, LocalDateTime created_time, LocalDateTime last_modified_time, Integer priority, String status, String created_by_user, List<String> members, LocalDateTime due_date, Boolean isArchived, List<CommentEntity> comments, String url ,String assigned_to) {
        this.title = title;
        this.description = description;
        this.created_time = created_time;
        this.last_modified_time = last_modified_time;
        this.priority = priority;
        this.status = status;
        this.created_by_user = created_by_user;
        this.due_date = due_date;
        this.isArchived = isArchived;
        this.comments = comments;
        this.url = url;
        this.assigned_to = assigned_to;
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

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}

