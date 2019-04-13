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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
    public void whenGetIssuesIsCalledAListOfIssuesIsReturned() {
        List<IssueEntity> issueEntities = new ArrayList<>();
        issueEntities.add(new IssueEntity());
        issueEntities.add(new IssueEntity());
        when(issueRepository.findAll()).thenReturn(issueEntities);

        ResponseEntity<List<IssueResponse>> response = issueProcessor.getIssues(null);

        assertThat(response.getBody().size()).isEqualTo(2);
    }
}
