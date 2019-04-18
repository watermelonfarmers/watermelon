package com.watermelonfarmers.watermelon.models.issues;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class IssueRequest {

    @ApiModelProperty(value = "title", example = "Add Issue API to watermelon service")
    private String title;
    @ApiModelProperty(value = "description", example = "This is very important")
    private String description;
    @NotEmpty(message = "issue steps is a required field", groups = { IssueRequest.Create.class })
    @Size(max = 4000, message = "issue steps can not be more than 4000 characters", groups = { IssueRequest.Create.class,
            IssueRequest.Update.class })
    @ApiModelProperty(value = "steps", example = "Steps to reproduce")
    private String steps;
    @ApiModelProperty(value = "priority", example = "10")
    private Integer priority;
    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;
    @ApiModelProperty(value = "estimate", example = "3")
    private Long estimate;
    @ApiModelProperty(value = "createdByUserId", example = "1")
    private Long createdByUserId;
    @ApiModelProperty(value = "assignedUserId", example = "1")
    private Long assignedUserId;
    @ApiModelProperty(value = "projectId", example = "1")
    private Long projectId;


    public interface Create {
    }

    public interface Update {
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

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public Long getEstimate() {
        return estimate;
    }

    public void setEstimate(Long estimate) {
        this.estimate = estimate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
