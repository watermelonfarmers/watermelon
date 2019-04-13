package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import com.watermelonfarmers.watermelon.models.projects.ProjectResponse;

public class ProjectMapper {

    public static ProjectEntity mapProjectRequestToProjectEntity(ProjectEntity projectEntity, ProjectRequest request) {
        if (null != request.getProjectName()) {
            projectEntity.setProjectName(request.getProjectName());
        }

        return projectEntity;
    }

    public static ProjectResponse mapProjectEntityToProjectResponse(ProjectEntity projectEntity) {
        ProjectResponse issue = new ProjectResponse();
        if (null != projectEntity.getProjectId()) {
            issue.setProjectId(projectEntity.getProjectId());
        }

        if (null != projectEntity.getProjectName()) {
            issue.setProjectName(projectEntity.getProjectName());
        }

        return issue;
    }
}
