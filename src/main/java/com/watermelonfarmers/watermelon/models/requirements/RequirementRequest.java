package com.watermelonfarmers.watermelon.models.requirements;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RequirementRequest {

    @ApiModelProperty(value = "title", example = "This is the title of the requirement")
    @NotNull(message = "Title is a required field", groups = { RequirementRequest.Create.class})
    @Size(max = 255, message = "Title can not be more than 255 characters", groups = { RequirementRequest.Create.class, RequirementRequest.Update.class})
    private String title;

    @Size(max = 10240, message = "Description can not be more than 10240 characters", groups ={ RequirementRequest.Create.class, RequirementRequest.Update.class})
    @ApiModelProperty(value = "description", example = "This is the description of the requirement")
    private String description;

    @ApiModelProperty(value = "priority", example = "Normal")
    private String priority;

    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;

    @ApiModelProperty(value = "dueDate", example = "2019-02-18T20:53:58")
    private LocalDateTime dueDate;

    @ApiModelProperty(value = "isArchived", example = "False")
    private Boolean isArchived;

    @ApiModelProperty(value = "createdByUser", example = "1")
    private Long createdByUser;

    @ApiModelProperty(value = "assignedToUser", example = "1")
    private Long assignedToUser;

    @ApiModelProperty(value = "relatedIssueId", example = "1")
    private Long relatedIssueId;

    public interface Create {

    }

    public interface Update {

    }

    public RequirementRequest() {
    }

    public RequirementRequest(@NotNull(message = "Title is a required field", groups = {Create.class}) @Size(max = 255, message = "Title can not be more than 255 characters", groups = {Create.class, Update.class}) String title, @Size(max = 10240, message = "Description can not be more than 10240 characters", groups = {Create.class, Update.class}) String description, String priority, String status, LocalDateTime dueDate, Boolean isArchived, Long createdByUser, Long assignedToUser, Long relatedIssueId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.isArchived = isArchived;
        this.createdByUser = createdByUser;
        this.assignedToUser = assignedToUser;
        this.relatedIssueId = relatedIssueId;
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

    public Long getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(Long createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Long getAssignedToUser() {
        return assignedToUser;
    }

    public void setAssignedToUser(Long assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    public Long getRelatedIssueId() {
        return relatedIssueId;
    }

    public void setRelatedIssueId(Long relatedIssueId) {
        this.relatedIssueId = relatedIssueId;
    }
}
