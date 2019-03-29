package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.processors.RequirementProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/requirements")
@Api(tags = "requirements", description = "requirements api")
public class RequirementController {

    private RequirementProcessor requirementProcessor;

    @Autowired
    public RequirementController(RequirementProcessor requirementProcessor) {
        this.requirementProcessor = requirementProcessor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createRequirement(@Validated(RequirementRequest.Create.class) @RequestBody RequirementRequest request) {
        return requirementProcessor.createRequirement(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RequirementResponse>> readAllRequirement() {
        return requirementProcessor.readAllRequirement();
    }

    @RequestMapping(value = "/{requirementId}", method = RequestMethod.GET)
    public ResponseEntity<RequirementResponse> readOneRequirement(@PathVariable Long requirementId) {
        return requirementProcessor.readOneRequirement(requirementId);
    }

    @RequestMapping(value = "/{requirementId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateRequirement(@Validated(RequirementRequest.Update.class) @RequestBody RequirementRequest request,
                                               @PathVariable Long requirementId) {
        return requirementProcessor.updateRequirement(request,requirementId);
    }

    @RequestMapping(value = "/{requirementId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRequirement(@PathVariable Long requirementId) {
        return requirementProcessor.deleteRequirement(requirementId);
    }



}
