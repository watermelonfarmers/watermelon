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

    public ResponseEntity<List<IssueResponse>> getIssues() {
        Iterable<IssueEntity> issueEntities = issueRepository.findAll();
        List<IssueResponse> issues = new ArrayList<>();
        for (IssueEntity issueEntity : issueEntities) {
            IssueResponse issue = IssueMapper.mapIssueEntityToIssueResponse(issueEntity);
            issues.add(issue);
        }
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

    public ResponseEntity<?> createIssue(IssueRequest request) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        IssueEntity issueEntity = IssueMapper.mapIssueRequestToIssueEntity(new IssueEntity(), request);
        issueRepository.save(issueEntity);
        return response;
    }

    public ResponseEntity<?> deleteIssue(Long issueId) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<IssueEntity> channelEntity = issueRepository.findById(issueId);

        if (channelEntity.isPresent()) {
            issueRepository.delete(channelEntity.get());
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    public ResponseEntity updateIssue(IssueRequest request, Long issueId) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<IssueEntity> channelEntity = issueRepository.findById(issueId);
        if (channelEntity.isPresent()) {
            IssueEntity updatedChannel = IssueMapper.mapIssueRequestToIssueEntity(channelEntity.get(), request);
            issueRepository.save(updatedChannel);
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
