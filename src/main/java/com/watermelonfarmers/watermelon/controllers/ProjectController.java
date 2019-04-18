package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import com.watermelonfarmers.watermelon.models.projects.ProjectResponse;
import com.watermelonfarmers.watermelon.processors.ProjectProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Api(tags = "projects", description = "projects api")
public class ProjectController {

    private ProjectProcessor projectProcessor;

    @Autowired
    public ProjectController(ProjectProcessor projectProcessor) {
        this.projectProcessor = projectProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProjectResponse>> getProjects() {
        return projectProcessor.getProjects();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProject(
            @Validated(ProjectRequest.Create.class) @RequestBody ProjectRequest request) {
        return projectProcessor.createProject(request);
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProject(@Validated(ProjectRequest.Update.class) @RequestBody ProjectRequest request,
            @PathVariable("projectId") Long projectId) {
        return projectProcessor.updateProject(request, projectId);
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProject(@PathVariable("projectId") Long projectId) {
        return projectProcessor.deleteProject(projectId);
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable("projectId") Long projectId) {
        return projectProcessor.getProjectsByProjectId(projectId);
    }
}
