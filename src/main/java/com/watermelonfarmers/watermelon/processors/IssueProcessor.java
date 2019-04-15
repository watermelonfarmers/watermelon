package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.mappers.IssueMapper;
import com.watermelonfarmers.watermelon.models.issues.IssueRequest;
import com.watermelonfarmers.watermelon.models.issues.IssueResponse;
import com.watermelonfarmers.watermelon.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IssueProcessor {

    private IssueRepository issueRepository;

    @Autowired
    public IssueProcessor(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public ResponseEntity<List<IssueResponse>> getIssues(Long projectId) {
        Iterable<IssueEntity> issueEntities;
        if (null != projectId) {
            issueEntities = issueRepository.findAllByProjectEntityProjectId(projectId);
        }
        else {
            issueEntities = issueRepository.findAll();
        }
        List<IssueResponse> issues = new ArrayList<>();
        for (IssueEntity issueEntity : issueEntities) {
            IssueResponse issue = IssueMapper.mapIssueEntityToIssueResponse(issueEntity);
            issues.add(issue);
        }
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

    public ResponseEntity<?> getIssueById(Long issueId) {
        ResponseEntity<?> response;
        Optional<IssueEntity> issueEntity = issueRepository.findById(issueId);
        if (issueEntity.isPresent()) {
            IssueResponse issue = IssueMapper.mapIssueEntityToIssueResponse(issueEntity.get());
            response = new ResponseEntity<>(issue, HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public ResponseEntity<HttpStatus> createIssue(IssueRequest request) {
        ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        IssueEntity issueEntity = IssueMapper.mapIssueRequestToIssueEntity(new IssueEntity(), request);
        issueRepository.save(issueEntity);
        return response;
    }

    public ResponseEntity<HttpStatus> deleteIssue(Long issueId) {
        ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        Optional<IssueEntity> issueEntity = issueRepository.findById(issueId);
        if (issueEntity.isPresent()) {
            issueRepository.delete(issueEntity.get());
        }
        else {
            response = new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public ResponseEntity<HttpStatus> updateIssue(IssueRequest request, Long issueId) {
        ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        Optional<IssueEntity> issueEntity = issueRepository.findById(issueId);
        if (issueEntity.isPresent()) {
            IssueEntity updatedChannel = IssueMapper.mapIssueRequestToIssueEntity(issueEntity.get(), request);
            issueRepository.save(updatedChannel);
        }
        else {
            response = new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
