package com.watermelonfarmers.watermelon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.watermelonfarmers.watermelon.models.Issue;
import com.watermelonfarmers.watermelon.processors.IssueProcessor;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private IssueProcessor issueProcessor;

    @Autowired
    public IssueController(IssueProcessor issueProcessor) {
        this.issueProcessor = issueProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Issue>> getIssues() {
        return issueProcessor.getIssues();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createIssue(@RequestBody Issue request) {
        return issueProcessor.createIssue(request);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateIssue(@RequestBody Issue request) {
        return issueProcessor.createIssue(request);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteIssue(@RequestBody Issue request) {
        return issueProcessor.deleteIssue(request);
    }
}
