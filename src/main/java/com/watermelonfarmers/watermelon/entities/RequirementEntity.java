package com.watermelonfarmers.watermelon.entities;

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
//    @Column(name = "Created_time")
    @CreationTimestamp
    private LocalDateTime created_time;
//    @Column(name = "Last_modified_time")
    @UpdateTimestamp
    private LocalDateTime last_modified_time;
    @Column(name = "Title")
    @Size(max = 255)
    private String title;
    @Column(name = "Description")
    @Size(max = 10240)
    private String description;
    @Column(name = "Priority")//Choose from 1 ~ 10
    private Integer priority;
    @Column(name = "Status")//Choose from the Number of the card
    private String status;
    @Column(name = "isArchived")
    private Boolean isArchived;
    @Column(name = "Due_date")
    private LocalDateTime due_date;
    @Column(name = "Url")
    private String url;

    @OneToMany(mappedBy = "requirement")
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToOne
    private UserEntity created_by_user;

    @OneToOne
    private UserEntity assigned_to_user;


    public RequirementEntity() {
    }

    public RequirementEntity(LocalDateTime created_time, LocalDateTime last_modified_time, String title, String description,
                             Integer priority, String status,LocalDateTime due_date, Boolean isArchived, String url,
                             UserEntity created_by_user, UserEntity assigned_to_user) {
        this.created_time = created_time;
        this.last_modified_time = last_modified_time;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.due_date = due_date;
        this.isArchived = isArchived;
        this.url = url;
        this.created_by_user = created_by_user;
        this.assigned_to_user = assigned_to_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(LocalDateTime last_modified_time) {
        this.last_modified_time = last_modified_time;
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

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void addComment (CommentEntity comment) {
        this.comments.add(comment);
    }

    public void removeComment (CommentEntity comment) {
        this.comments.remove(comment);
    }


    public UserEntity getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(UserEntity created_by_user) {
        this.created_by_user = created_by_user;
    }

    public UserEntity getAssigned_to_user() {
        return assigned_to_user;
    }

    public void setAssigned_to_user(UserEntity assigned_to_user) {
        this.assigned_to_user = assigned_to_user;
    }
}
