package com.watermelonfarmers.watermelon.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ISSUE")
public class IssueEntity {

    @Id
    @GeneratedValue
    @Column(name = "ISSUE_ID", unique = true)
    private Long issueId;
    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED")
    private LocalDateTime lastModified;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 400)
    @Column(name = "STEPS")
    private String steps;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ESTIMATE")
    private Long estimate;
    @OneToOne
    @JoinColumn(name = "CREATED_BY_USER_ID")
    private UserEntity createdByUser;
    @OneToOne
    @JoinColumn(name = "ASSIGNED_USER_ID")
    private UserEntity assignedUser;
    @OneToOne
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity projectEntity;
    @OneToMany(mappedBy = "issueEntity")
    private List<RequirementEntity> requirementEntities;

    public IssueEntity() {
    }

    public IssueEntity(Long issueId, LocalDateTime created, LocalDateTime lastModified, String title, String description, Long estimate, String steps, Integer priority, String status, UserEntity createdByUser, UserEntity assignedUser, ProjectEntity projectEntity, List<RequirementEntity> requirementEntities) {
        this.issueId = issueId;
        this.created = created;
        this.lastModified = lastModified;
        this.title = title;
        this.description = description;
        this.steps = steps;
        this.priority = priority;
        this.status = status;
        this.estimate = estimate;
        this.createdByUser = createdByUser;
        this.assignedUser = assignedUser;
        this.projectEntity = projectEntity;
        this.requirementEntities = requirementEntities;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserEntity createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserEntity getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(UserEntity assignedUser) {
        this.assignedUser = assignedUser;
    }

    public List<RequirementEntity> getRequirementEntities() {
        return requirementEntities;
    }

    public void setRequirementEntities(List<RequirementEntity> requirementEntities) {
        this.requirementEntities = requirementEntities;
    }

    public Long getEstimate() {
        return estimate;
    }

    public void setEstimate(Long estimate) {
        this.estimate = estimate;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }
}
