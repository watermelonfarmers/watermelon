package com.watermelonfarmers.watermelon.processors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.models.Issue;
import com.watermelonfarmers.watermelon.repositories.IssueRepository;

public class IssueProcessorTest {

    public static final String ALREADY_EXISTS = "already exists";

    private IssueProcessor issueProcessor;

    @Mock
    private IssueRepository issueRepository;

    @Mock
    private IssueEntity issueEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        issueProcessor = new IssueProcessor(issueRepository);
    }

    @Test
    public void whenCreateIssueIsCalledIssueIsCreatedAndResponseStatusCodeIsOK() {
        when(issueRepository.save(any())).thenReturn(issueEntity);

        ResponseEntity response = issueProcessor.createIssue(new Issue());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenCreateIssueIsCalledAndIssueIdAlreadyExistsResponseStatusCodeIsConflict() {
        when(issueRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = issueProcessor.createIssue(new Issue());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenCreateIssueIsCalledAndIssueIdAlreadyExistsResponseIssueIsAlreadyExists() {
        when(issueRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = issueProcessor.createIssue(new Issue());

        assertThat(response.getBody()).isEqualTo(ALREADY_EXISTS);
    }

    @Test
    public void whenGetIssuesIsCalledAListOfIssuesIsReturned() {
        List<IssueEntity> issueEntities = new ArrayList<>();
        issueEntities.add(new IssueEntity());
        issueEntities.add(new IssueEntity());
        when(issueRepository.findAll()).thenReturn(issueEntities);

        ResponseEntity<List<Issue>> response = issueProcessor.getIssues();

        assertThat(response.getBody().size()).isEqualTo(2);
    }
}
