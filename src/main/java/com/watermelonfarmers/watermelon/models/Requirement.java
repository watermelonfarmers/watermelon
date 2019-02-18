package com.watermelonfarmers.watermelon.models;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;
import java.util.List;

public class Requirement {
    @ApiModelProperty(value = "id", example = "1")
    private long id;
    @ApiModelProperty(value = "created", example = "2019-02-18T20:53:58")
    private LocalDateTime created;
    @ApiModelProperty(value = "last_modified", example = "2019-02-18T20:53:58")
    private LocalDateTime last_modified;
    @ApiModelProperty(value = "title", example = "Sprint 1")
    private String title;
    @ApiModelProperty(value = "description", example = "This is very important")
    private String description;
    @ApiModelProperty(value = "priority", example = "HIGH")
    private String priority;
    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;
    @ApiModelProperty(value = "created_by_user", example = "Hannibal")
    private String created_by_user;

//    //GOOD TO HAVE
//    @ApiModelProperty(value = "due_date", example = "01.01 2019")
//    private LocalDateTime due_date;
//
//    //NICE TO HAVE
//    @ApiModelProperty(value = "check_list", example = "XXXXXX")
//    private List<String> check_list;
//    @ApiModelProperty(value = "archive", example = "TRUE")
//    private Boolean archive;
//    @ApiModelProperty(value = "reviews", example = "XXXXXXX")
//    private List<String> reviews;
//    @ApiModelProperty(value = "url", example = "https://www.pivotaltracker.com/story/show/164053311")
//    private String url;

    public Requirement() {
    }

    public Requirement(long id, LocalDateTime created, LocalDateTime last_modified, String title, String description, String priority, String status, String created_by_user) {
        this.id = id;
        this.created = created;
        this.last_modified = last_modified;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_by_user = created_by_user;
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

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
    }
}

