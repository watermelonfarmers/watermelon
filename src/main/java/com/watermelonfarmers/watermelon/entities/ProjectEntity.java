package com.watermelonfarmers.watermelon.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "PROJECT")
public class ProjectEntity {

    @Id
    @GeneratedValue
    @Column(name = "PROJECT_ID", unique = true)
    private Long projectId;
    
    @Size(max = 255)
    @Column(name = "PROJECT_NAME")
    private String projectName;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED")
    private LocalDateTime lastUpdateTime;


    public ProjectEntity() {
    }

    public ProjectEntity(Long projectId, @Size(max = 255) String projectName, LocalDateTime createTime,
            LocalDateTime lastUpdateTime) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }


    public Long getProjectId() {
        return projectId;
    }


    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    public String getProjectName() {
        return projectName;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }


    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
}
