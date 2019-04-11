package com.watermelonfarmers.watermelon.processors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import com.watermelonfarmers.watermelon.models.projects.ProjectResponse;
import com.watermelonfarmers.watermelon.repositories.ProjectRepository;

public class ProjectProcessorTest {

    public static final long PROJECT_ID = 1l;
    private ProjectProcessor projectProcessor;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectEntity projectEntity;

    @Mock
    private ProjectRequest projectRequest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        projectProcessor = new ProjectProcessor(projectRepository);
    }

    @Test
    public void whenCreateProjectIsCalledProjectIsCreatedAndResponseStatusCodeIsCreated() {
        when(projectRepository.save(any())).thenReturn(projectEntity);
        ResponseEntity<?> response = projectProcessor.createProject(projectRequest);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void whenGetProjectsIsCalledAListOfProjectsIsReturned() {
        List<ProjectEntity> projectEntities = new ArrayList<>();
        projectEntities.add(projectEntity);
        projectEntities.add(projectEntity);
        when(projectRepository.findAll()).thenReturn(projectEntities);
        ResponseEntity<List<ProjectResponse>> response = projectProcessor.getProjects();
        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenUpdateProjectIsCalledHttpStatusIsOK() {
        Optional<ProjectEntity> projectOptional = Optional.of(projectEntity);
        when(projectRepository.findById(any())).thenReturn(projectOptional);
        ResponseEntity<?> response = projectProcessor.updateProject(projectRequest, PROJECT_ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenUpdateProjectIsCalledAndProjectIsNotFoundHttpStatusCodeIsNotFound() {
        Optional<ProjectEntity> projectOptional = Optional.empty();
        when(projectRepository.findById(any())).thenReturn(projectOptional);
        ResponseEntity<?> response = projectProcessor.updateProject(projectRequest, PROJECT_ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenDeleteProjectIsCalledHttpStatusIsOK() {
        Optional<ProjectEntity> projectOptional = Optional.of(projectEntity);
        when(projectRepository.findById(any())).thenReturn(projectOptional);
        ResponseEntity<?> response = projectProcessor.deleteProject(PROJECT_ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenDeleteProjectIsCalledAndProjectIsNotFoundHttpStatusCodeIsNotFound() {
        Optional<ProjectEntity> projectOptional = Optional.empty();
        when(projectRepository.findById(any())).thenReturn(projectOptional);
        ResponseEntity<?> response = projectProcessor.deleteProject(PROJECT_ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
