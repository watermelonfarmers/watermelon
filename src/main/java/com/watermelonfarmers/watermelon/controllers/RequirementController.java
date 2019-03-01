package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.processors.RequirementProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/requirements")

public class RequirementController {

    private RequirementProcessor requirementProcessor;

    @Autowired
    public RequirementController(RequirementProcessor requirementProcessor) {
        this.requirementProcessor = requirementProcessor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createRequirement(@RequestBody Requirement request) {
        return requirementProcessor.createRequirement(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readAllRequirement() {
        return requirementProcessor.readAllRequirement();
    }

    @RequestMapping(value = "/{requirementId}", method = RequestMethod.GET)
    public ResponseEntity readOneRequirement(@PathVariable Long requirementId) {
        return requirementProcessor.readOneRequirement(requirementId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateRequirement(@RequestBody Requirement request) {
        return requirementProcessor.updateRequirement(request);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteRequirement(@RequestBody Requirement request) {
        return requirementProcessor.deleteRequirement(request);
    }



}
