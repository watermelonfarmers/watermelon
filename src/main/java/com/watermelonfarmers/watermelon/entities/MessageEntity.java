package com.watermelonfarmers.watermelon.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private long id;

    @Size(max = 255)
    @Column(name = "BODY")
    private String body;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED")
    private LocalDateTime lastModified;

    @OneToOne
    @JoinColumn(name = "CREATED_BY_USER_ID")
    private UserEntity createdByUser;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    @JsonBackReference
    private ChannelEntity channelEntity;

    public MessageEntity() {
    }

    public MessageEntity(long id, @Size(max = 255) String body, LocalDateTime created, LocalDateTime lastModified, UserEntity createdByUser, ChannelEntity channelEntity) {
        this.id = id;
        this.body = body;
        this.created = created;
        this.lastModified = lastModified;
        this.createdByUser = createdByUser;
        this.channelEntity = channelEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public UserEntity getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserEntity createdByUser) {
        this.createdByUser = createdByUser;
    }

    public ChannelEntity getChannelEntity() {
        return channelEntity;
    }

    public void setChannelEntity(ChannelEntity channelEntity) {
        this.channelEntity = channelEntity;
    }
}
