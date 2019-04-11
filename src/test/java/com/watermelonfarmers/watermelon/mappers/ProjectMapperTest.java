package com.watermelonfarmers.watermelon.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import com.watermelonfarmers.watermelon.models.projects.ProjectResponse;

public class ProjectMapperTest {

    public static final String PROJECT = "Watermelon";
    public static final long PROJECT_ID = 1l;

    private ProjectRequest projectRequest;
    private ProjectResponse projectResponse;
    private ProjectEntity projectEntity;

    @Before
    public void setup() {
        this.projectRequest = new ProjectRequest();
        this.projectResponse = new ProjectResponse();
        this.projectEntity = new ProjectEntity();
    }

    @Test
    public void whenMapProjectEntityToProjectIdShouldBeId() {
        projectEntity.setProjectId(PROJECT_ID);
        projectResponse = ProjectMapper.mapProjectEntityToProjectResponse(projectEntity);
        assertThat(projectResponse.getProjectId()).isEqualTo(PROJECT_ID);
    }

    @Test
    public void whenMapProjectEntityToProjectNameShouldBeName() {
        projectEntity.setProjectName(PROJECT);
        projectResponse = ProjectMapper.mapProjectEntityToProjectResponse(projectEntity);
        assertThat(projectResponse.getProjectName()).isEqualTo(PROJECT);
    }

    @Test
    public void whenMapProjectEntityToProjectCreatedShouldBeCreated() {
        LocalDateTime now = LocalDateTime.now();
        projectEntity.setCreateTime(now);
        projectResponse = ProjectMapper.mapProjectEntityToProjectResponse(projectEntity);
        assertThat(projectResponse.getCreated()).isEqualTo(now);
    }

    @Test
    public void whenMapProjectEntityToProjectUpdatedShouldBeUpdated() {
        LocalDateTime now = LocalDateTime.now();
        projectEntity.setLastUpdateTime(now);
        projectResponse = ProjectMapper.mapProjectEntityToProjectResponse(projectEntity);
        assertThat(projectResponse.getUpdated()).isEqualTo(now);
    }

    @Test
    public void whenMapProjectRequestToProjectEntityBodyShouldBeMappedToProjectName() {
        projectRequest.setProjectName(PROJECT);
        projectEntity = ProjectMapper.mapProjectRequestToProjectEntity(projectEntity, projectRequest);
        assertThat(projectEntity.getProjectName()).isEqualTo(PROJECT);
    }
}
