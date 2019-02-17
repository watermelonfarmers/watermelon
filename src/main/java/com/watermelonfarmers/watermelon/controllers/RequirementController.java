package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.processors.RequirementProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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


}
