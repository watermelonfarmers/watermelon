package com.watermelonfarmers.watermelon.models.projects;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectRequest {

    @NotEmpty(message = "project name is a required field", groups = { ProjectRequest.Create.class })
    @Size(max = 255, message = "project name can not be more than 255 characters", groups = {
            ProjectRequest.Create.class, ProjectRequest.Update.class })
    @ApiModelProperty(value = "projectName", example = "Watermelon")
    private String projectName;

    public interface Create {
    }

    public interface Update {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
