package com.watermelonfarmers.watermelon.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REQUIREMENT")
public class RequirementEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true)
    private long id;
    @Column(name = "Created")
    private LocalDateTime created;
    @Column(name = "Last_modified")
    private LocalDateTime last_modified;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Prioirty")
    private String priority;
    @Column(name = "Status")
    private String status;
    @Column(name = "Created_by_user")
    private String created_by_user;


    public RequirementEntity() {
    }

    public RequirementEntity(LocalDateTime created, LocalDateTime last_modified, String title, String description, String priority, String status, String created_by_user) {
        this.created = created;
        this.last_modified = last_modified;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_by_user = created_by_user;
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

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
    }
}
