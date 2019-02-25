package com.watermelonfarmers.watermelon.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.models.Issue;

public class IssueMapperTest {

    public static final String TITLE = "Hello";

    private Issue issue;

    private IssueEntity issueEntity;

    @Before
    public void setup() {
        this.issue = new Issue();
        this.issueEntity = new IssueEntity();
    }

    @Test
    public void whenMapIssueEntityToIssueTitleShouldBeTitle() {
        issueEntity.setTitle(TITLE);

        issue = IssueMapper.mapIssueToIssueEntity(issueEntity);

        assertThat(issue.getTitle()).isEqualTo(TITLE);
    }
    
}
