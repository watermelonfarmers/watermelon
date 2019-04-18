package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.issues.IssueRequest;
import com.watermelonfarmers.watermelon.models.issues.IssueResponse;
import com.watermelonfarmers.watermelon.processors.IssueProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
@Api(tags = "issues", description = "issues api")
public class IssueController {

    private IssueProcessor issueProcessor;

    @Autowired
    public IssueController(IssueProcessor issueProcessor) {
        this.issueProcessor = issueProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<IssueResponse>> getIssues(@RequestParam(value = "project", required = false) Long projectId) {
        return issueProcessor.getIssues(projectId);
    }

    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
    public ResponseEntity<?> getIssueById(@PathVariable("issueId") Long issueId) {
        return issueProcessor.getIssueById(issueId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createIssue(@RequestBody IssueRequest request) {
        return issueProcessor.createIssue(request);
    }
    
    @RequestMapping(value = "/{issueId}", method = RequestMethod.PUT)
    public ResponseEntity updateIssue(@RequestBody IssueRequest request, @PathVariable("issueId") Long issueId) {
        return issueProcessor.updateIssue(request, issueId);
    }

    @RequestMapping(value = "/{issueId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteIssue(@PathVariable("issueId") Long issueId) {
        return issueProcessor.deleteIssue(issueId);
    }
}
