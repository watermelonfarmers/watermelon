package com.watermelonfarmers.watermelon.models.requirements;

public class RequirementIssueResponse {

    private Long issueId;
    private String title;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
