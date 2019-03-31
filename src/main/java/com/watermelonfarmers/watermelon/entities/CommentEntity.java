package com.watermelonfarmers.watermelon.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private LocalDateTime create_time;

    @UpdateTimestamp
    private LocalDateTime last_update_time;

    private String content;

    @OneToOne
    private UserEntity user;

    @ManyToOne
    private RequirementEntity requirement;

    public CommentEntity() {
    }

    public CommentEntity(LocalDateTime create_time, LocalDateTime last_update_time, String content, UserEntity user, RequirementEntity requirement) {
        this.create_time = create_time;
        this.last_update_time = last_update_time;
        this.content = content;
        this.user = user;
        this.requirement = requirement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(LocalDateTime last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
