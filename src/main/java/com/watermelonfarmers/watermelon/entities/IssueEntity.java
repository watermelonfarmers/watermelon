package com.watermelonfarmers.watermelon.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ISSUE")
public class IssueEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    private long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime last_modified;
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Prioirty")
    private Integer priority;
    @Column(name = "Status")
    private String status;
    @Column(name = "Created_by_user_id")
    private long created_by_user_id;
    @Column(name = "Assigned_user_id")
    private long assigned_user_id;

    public IssueEntity() {
    }

    public IssueEntity(long id, LocalDateTime created, LocalDateTime last_modified, String title,
            String description, Integer priority, String status, long created_by_user_id, long assigned_user_id) {
        this.id = id;
        this.created = created;
        this.last_modified = last_modified;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_by_user_id = created_by_user_id;
        this.assigned_user_id = assigned_user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(LocalDateTime last_modified) {
        this.last_modified = last_modified;
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

    public long getCreated_by_user_id() {
        return created_by_user_id;
    }

    public void setCreated_by_user_id(long created_by_user_id) {
        this.created_by_user_id = created_by_user_id;
    }

    public long getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(long assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

}
