package com.watermelonfarmers.watermelon.models.issues;

public class IssueRequirementResponse {

    private Long requirementId;
    private String title;

    public Long getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
