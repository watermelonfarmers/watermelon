package com.watermelonfarmers.watermelon.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Requirement")
public class RequirementEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id",unique = true)
    private long id;
    @Column(name = "CreatedTime")
    @CreationTimestamp
    private LocalDateTime createdTime;
    @Column(name = "Last_modified_time")
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;
    @Column(name = "Title")
    @Size(max = 255)
    private String title;
    @Column(name = "Description")
    @Size(max = 2000)
    private String description;
    @Column(name = "Priority")//Choose from Normal Urgent VeryUrgent
    private String priority;
    @Column(name = "Status")//Choose from the Number of the card
    private String status;
    @Column(name = "isArchived")
    private Boolean isArchived;
    @Column(name = "DueDate")
    private LocalDateTime dueDate;
    @Column(name = "EstimatedTime")
    private String estimatedTime;

    @OneToMany(mappedBy = "requirement", cascade = CascadeType.REMOVE)
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "requirement", cascade = CascadeType.REMOVE)
    private List<ActivityEntity> activities = new ArrayList<>();

    @OneToOne
    private UserEntity createdByUser;

    @OneToOne
    private UserEntity assignedToUser;

    @OneToOne
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name = "ISSUE_ID")
    @JsonBackReference
    private IssueEntity issueEntity;

    public RequirementEntity() {
    }

    public RequirementEntity(long id, LocalDateTime createdTime, LocalDateTime lastModifiedTime, @Size(max = 255) String title, @Size(max = 2000) String description, String priority, String status, Boolean isArchived, LocalDateTime dueDate, String estimatedTime, List<CommentEntity> comments, List<ActivityEntity> activities, UserEntity createdByUser, UserEntity assignedToUser, ProjectEntity projectEntity, IssueEntity issueEntity) {
        this.id = id;
        this.createdTime = createdTime;
        this.lastModifiedTime = lastModifiedTime;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.isArchived = isArchived;
        this.dueDate = dueDate;
        this.estimatedTime = estimatedTime;
        this.comments = comments;
        this.activities = activities;
        this.createdByUser = createdByUser;
        this.assignedToUser = assignedToUser;
        this.projectEntity = projectEntity;
        this.issueEntity = issueEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityEntity> activities) {
        this.activities = activities;
    }

    public UserEntity getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserEntity createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserEntity getAssignedToUser() {
        return assignedToUser;
    }

    public void setAssignedToUser(UserEntity assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public IssueEntity getIssueEntity() {
        return issueEntity;
    }

    public void setIssueEntity(IssueEntity issueEntity) {
        this.issueEntity = issueEntity;
    }
}
