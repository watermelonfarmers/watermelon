package com.watermelonfarmers.watermelon.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "REQUIREMENT")
public class RequirementEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true)
    private long id;
    @Column(name = "Created_time")
    private LocalDateTime created_time;
    @Column(name = "Last_modified_time")
    private LocalDateTime last_modified_time;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Prioirty")
    private Integer priority;
    @Column(name = "Status")
    private String status;
    @Column(name = "Created_by_user")
    private String created_by_user;
    @Column(name = "Members")
    private List<String> members;

    @Column(name = "Due_date")
    private LocalDateTime due_date;
    @Column(name = "Check_list")
    private List<String> check_list;
    @Column(name = "isArchived")
    private Boolean isArchived;
    @Column(name = "Comments")
    private List<String> comments;
    @Column(name = "Activity")
    private List<String> activity;
    @Column(name = "Url")
    private String url;

    public RequirementEntity() {
    }

    public RequirementEntity(LocalDateTime created_time, LocalDateTime last_modified_time, String title, String description, Integer priority, String status, String created_by_user, List<String> members, LocalDateTime due_date, List<String> check_list, Boolean isArchived, List<String> comments, List<String> activity, String url) {
        this.created_time = created_time;
        this.last_modified_time = last_modified_time;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_by_user = created_by_user;
        this.members = members;
        this.due_date = due_date;
        this.check_list = check_list;
        this.isArchived = isArchived;
        this.comments = comments;
        this.activity = activity;
        this.url = url;
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

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public List<String> getCheck_list() {
        return check_list;
    }

    public void setCheck_list(List<String> check_list) {
        this.check_list = check_list;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getActivity() {
        return activity;
    }

    public void setActivity(List<String> activity) {
        this.activity = activity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
