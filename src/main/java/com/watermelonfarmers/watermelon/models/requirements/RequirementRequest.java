package com.watermelonfarmers.watermelon.models.requirements;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class RequirementRequest {

    @ApiModelProperty(value = "title", example = "This is the title of the requirement")
    @NotNull(message = "Title is a required field", groups = { RequirementRequest.Create.class})
    @Size(max = 255, message = "Title can not be more than 255 characters", groups = { RequirementRequest.Create.class, RequirementRequest.Update.class})
    private String title;

    @Size(max = 10240, message = "Description can not be more than 10240 characters", groups ={ RequirementRequest.Create.class, RequirementRequest.Update.class})
    @ApiModelProperty(value = "description", example = "This is the description of the requirement")
    private String description;

//    @ApiModelProperty(value = "created_time", example = "2019-02-18T20:53:58")
//    private LocalDateTime created_time;
//
//    @ApiModelProperty(value = "last_modified_time", example = "2019-02-18T20:53:58")
//    private LocalDateTime last_modified_time;

    @ApiModelProperty(value = "priority", example = "10")
    private Integer priority;

    @ApiModelProperty(value = "status", example = "IN PROGRESS")
    private String status;

    @ApiModelProperty(value = "due_date", example = "2019-02-18T20:53:58")
    private LocalDateTime due_date;

    @ApiModelProperty(value = "isArchived", example = "False")
    private Boolean isArchived;

    //    @ApiModelProperty(value = "comments", example = "Nice job!")
    private List<CommentEntity> comments;

    @ApiModelProperty(value = "created_by_user", example = "1")
    private Long created_by_user;

    @ApiModelProperty(value = "assigned_to_user", example = "1")
    private Long assigned_to_user;

    public interface Create {

    }

    public interface Update {

    }

    public RequirementRequest() {
    }

    public RequirementRequest(Long id, String title, String description, Integer priority, String status,
                              Long created_by_user, List<String> members, LocalDateTime due_date, Boolean isArchived, List<CommentEntity> comments, Long assigned_to_user) {
        this.title = title;
        this.description = description;
//        this.created_time = created_time;
//        this.last_modified_time = last_modified_time;
        this.priority = priority;
        this.status = status;
        this.created_by_user = created_by_user;
        this.due_date = due_date;
        this.isArchived = isArchived;
        this.comments = comments;
        this.assigned_to_user = assigned_to_user;
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

    public Long getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(Long created_by_user) {
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

    public Long getAssigned_to_user() {
        return assigned_to_user;
    }

    public void setAssigned_to_user(Long assigned_to_user) {
        this.assigned_to_user = assigned_to_user;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
