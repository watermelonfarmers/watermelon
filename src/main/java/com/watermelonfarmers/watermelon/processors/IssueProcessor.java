package com.watermelonfarmers.watermelon.processors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.mappers.IssueMapper;
import com.watermelonfarmers.watermelon.models.Issue;
import com.watermelonfarmers.watermelon.repositories.IssueRepository;

@Service
public class IssueProcessor {

    private IssueRepository issueRepository;

    @Autowired
    public IssueProcessor(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public ResponseEntity<List<Issue>> getIssues() {
        Iterable<IssueEntity> issueEntities = issueRepository.findAll();
        List<Issue> issues = new ArrayList<>();
        for (IssueEntity issueEntity : issueEntities) {
            Issue issue = IssueMapper.mapIssueToIssueEntity(issueEntity);
            issues.add(issue);
        }
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

    public ResponseEntity<String> createIssue(Issue request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        IssueEntity issueEntity = IssueMapper.mapIssueEntityToIssue(request);
        try {
            issueRepository.save(issueEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity<String>("already exists", HttpStatus.CONFLICT);
        }
        return response;
    }

    public ResponseEntity<String> deleteIssue(Issue request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        IssueEntity issueEntity = IssueMapper.mapIssueEntityToIssue(request);
        issueRepository.delete(issueEntity);
        return response;
    }
}
