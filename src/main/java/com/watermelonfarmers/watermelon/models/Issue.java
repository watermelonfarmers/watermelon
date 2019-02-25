package com.watermelonfarmers.watermelon.models;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class Issue {
    @ApiModelProperty(value = "id", example = "1")
    private long id;
    @ApiModelProperty(value = "created", example = "2019-02-18T20:53:58")
    private LocalDateTime created;
    @ApiModelProperty(value = "last_modified", example = "2019-02-18T20:53:58")
    private LocalDateTime last_modified;
    @ApiModelProperty(value = "title", example = "Add Issue API to watermelon service")
    private String title;
    @ApiModelProperty(value = "description", example = "This is very important")
    private String description;
    @ApiModelProperty(value = "priority", example = "10")
    private Integer priority;
    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;
    @ApiModelProperty(value = "created_by_user_id", example = "1")
    private long created_by_user_id;
    @ApiModelProperty(value = "assigned_user_id", example = "2")
    private long assigned_user_id;

    public Issue() {
    }

    public Issue(long id, LocalDateTime created, LocalDateTime last_modified, String title, String description,
            Integer priority, String status, long created_by_user_id, long assigned_user_id) {
        this.id = id;
        this.created = created;
        this.last_modified = last_modified;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_by_user_id = created_by_user_id;
        this.assigned_user_id = assigned_user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getCreated_by_user_id() {
        return created_by_user_id;
    }

    public void setCreated_by_user_id(long created_by_user_id) {
        this.created_by_user_id = created_by_user_id;
    }

    public long getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(long assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

}
