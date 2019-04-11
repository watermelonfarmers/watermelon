package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.mappers.ProjectMapper;
import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import com.watermelonfarmers.watermelon.models.projects.ProjectResponse;
import com.watermelonfarmers.watermelon.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectProcessor {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectProcessor(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ResponseEntity<List<ProjectResponse>> getProjects() {
        Iterable<ProjectEntity> projectEntities = projectRepository.findAll();
        return getProjectResponseListFromEntityList(projectEntities);
    }

    public ResponseEntity<HttpStatus> createProject(ProjectRequest request) {
        ProjectEntity projectEntity = ProjectMapper.mapProjectRequestToProjectEntity(new ProjectEntity(), request);
        projectRepository.save(projectEntity);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> updateProject(ProjectRequest request, Long projectId) {
        ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        Optional<ProjectEntity> projectEntity = projectRepository.findById(projectId);
        if (projectEntity.isPresent()) {
            ProjectEntity updatedProject = ProjectMapper.mapProjectRequestToProjectEntity(projectEntity.get(), request);
            projectRepository.save(updatedProject);
        } else {
            response = new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public ResponseEntity<HttpStatus> deleteProject(Long projectId) {
        ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        Optional<ProjectEntity> projectEntity = projectRepository.findById(projectId);
        if (projectEntity.isPresent()) {
            projectRepository.delete(projectEntity.get());
        } else {
            response = new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public ResponseEntity<List<ProjectResponse>> getProjectsByProjectId(long projectId) {
        Iterable<ProjectEntity> projectEntities = projectRepository.findAllByProjectId(projectId);
        return getProjectResponseListFromEntityList(projectEntities);
    }

    private ResponseEntity<List<ProjectResponse>> getProjectResponseListFromEntityList(
            Iterable<ProjectEntity> projectEntities) {
        List<ProjectResponse> projects = new ArrayList<>();
        for (ProjectEntity projectEntity : projectEntities) {
            ProjectResponse project = ProjectMapper.mapProjectEntityToProjectResponse(projectEntity);
            projects.add(project);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
