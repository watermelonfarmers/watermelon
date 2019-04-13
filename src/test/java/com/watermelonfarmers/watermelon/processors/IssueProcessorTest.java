package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.models.issues.IssueRequest;
import com.watermelonfarmers.watermelon.models.issues.IssueResponse;
import com.watermelonfarmers.watermelon.repositories.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class IssueProcessorTest {

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

        ResponseEntity response = issueProcessor.createIssue(new IssueRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenGetIssuesIsCalledAndNoProjectIdIsProvidedListOfIssuesIsReturned() {
        List<IssueEntity> issueEntities = new ArrayList<>();
        issueEntities.add(new IssueEntity());
        issueEntities.add(new IssueEntity());
        when(issueRepository.findAll()).thenReturn(issueEntities);

        ResponseEntity<List<IssueResponse>> response = issueProcessor.getIssues(null);

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenGetIssuesIsCalledAndProjectIdIsProvidedAListOfIssuesIsReturned() {
        List<IssueEntity> issueEntities = new ArrayList<>();
        issueEntities.add(new IssueEntity());
        issueEntities.add(new IssueEntity());
        when(issueRepository.findAllByProjectEntityProjectId(1l)).thenReturn(issueEntities);

        ResponseEntity<List<IssueResponse>> response = issueProcessor.getIssues(1l);

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenGetIssuesByIdIsCalledAndResourceExistsIssueIsReturned() {
        Optional<IssueEntity> optionalIssue = Optional.of(issueEntity);
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);

        ResponseEntity<?> response = issueProcessor.getIssueById(1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenGetIssuesByIdIsCalledAndResourceDoesNotExistErrorIsReturned() {
        Optional<IssueEntity> optionalIssue = Optional.empty();
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);

        ResponseEntity<?> response = issueProcessor.getIssueById(1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenDeleteIssueIsCalledAndResourceExistsStatusIsOkay() {
        Optional<IssueEntity> optionalIssue = Optional.of(issueEntity);
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);
        doNothing().when(issueRepository).delete(any());

        ResponseEntity<?> response = issueProcessor.deleteIssue(1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenDeleteIssueIsCalledAndResourceDoesNotExistsStatusIsNotFound() {
        Optional<IssueEntity> optionalIssue = Optional.empty();
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);
        doNothing().when(issueRepository).delete(any());

        ResponseEntity<?> response = issueProcessor.deleteIssue(1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenUpdateIssueIsCalledAndResourceExistsStatusIsOkay() {
        Optional<IssueEntity> optionalIssue = Optional.of(issueEntity);
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);
        when(issueRepository.save(any())).thenReturn(issueEntity);

        ResponseEntity<?> response = issueProcessor.updateIssue(new IssueRequest(), 1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenUpdateIssueIsCalledAndResourceDoesNotExistsStatusIsNotFound() {
        Optional<IssueEntity> optionalIssue = Optional.empty();
        when(issueRepository.findById(1l)).thenReturn(optionalIssue);
        when(issueRepository.save(any())).thenReturn(issueEntity);

        ResponseEntity<?> response = issueProcessor.updateIssue(new IssueRequest(), 1l);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
