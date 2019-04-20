package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.Activity.ActivityRequest;
import com.watermelonfarmers.watermelon.models.Activity.ActivityResponse;
import com.watermelonfarmers.watermelon.processors.ActivityProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/activities")
@Api(tags = "activities", description = "activities api")
public class ActivityController {

    private ActivityProcessor activityProcessor;

    @Autowired
    public ActivityController(ActivityProcessor activityProcessor) {
        this.activityProcessor = activityProcessor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createActivity(@RequestBody ActivityRequest request) {
        return activityProcessor.createActivity(request);
    }

    @RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
    public ResponseEntity<ActivityResponse> getCommentById(@PathVariable Long activityId) {
        return activityProcessor.getActivityById(activityId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ActivityResponse>> reaAllActivities(@RequestParam(value = "project", required = false) Long projectId) {
        return activityProcessor.readAllActivities(projectId);
    }
}

