package com.watermelonfarmers.watermelon.models.projects;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectRequest {

    @NotNull(message = "project id is a required field", groups = { ProjectRequest.Create.class })
    @ApiModelProperty(value = "projectId", example = "1")
    private Long projectId;

    @NotEmpty(message = "project name is a required field", groups = { ProjectRequest.Create.class })
    @Size(max = 255, message = "project name can not be more than 255 characters", groups = {
            ProjectRequest.Create.class, ProjectRequest.Update.class })
    @ApiModelProperty(value = "projectName", example = "Watermelon")
    private String projectName;

    @ApiModelProperty(value = "createdDate", example = "2019-02-18T20:53:58")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "updatedDate", example = "2019-02-18T20:53:58")
    private LocalDateTime updatedDate;

    public interface Create {
    }

    public interface Update {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
