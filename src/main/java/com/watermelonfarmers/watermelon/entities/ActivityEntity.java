package com.watermelonfarmers.watermelon.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Activity")
public class ActivityEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id",unique = true)
    private long id;
    @Column(name = "CreatedTime")
    @CreationTimestamp
    private LocalDateTime createdTime;
    @Column(name = "Action")
    private String action;
    @Column(name = "target")
    private String target;
    @Column(name = "startPoint")
    private String startPoint;
    @Column(name = "endPoint")
    private String endPoint;

    @OneToOne
    private UserEntity user;

    @ManyToOne
    private RequirementEntity requirement;

    public ActivityEntity() {
    }

    public ActivityEntity(String action, String target, String startPoint, String endPoint, UserEntity user, RequirementEntity requirement) {
        this.action = action;
        this.target = target;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.user = user;
        this.requirement = requirement;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RequirementEntity getRequirement() {
        return requirement;
    }

    public void setRequirement(RequirementEntity requirement) {
        this.requirement = requirement;
    }
}



