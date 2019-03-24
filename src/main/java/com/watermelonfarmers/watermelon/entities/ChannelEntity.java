package com.watermelonfarmers.watermelon.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CHANNEL")
public class ChannelEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private long id;

    @Size(max = 255)
    @Column(name = "Channel_name")
    private String channel;

    @Column(name = "Created")
    private LocalDateTime created;

    @Column(name = "Last_modified")
    private LocalDateTime last_modified;

    @NotNull
    @Column(name = "Created_by_user")
    private String created_by_user;

    @OneToMany(mappedBy = "channelEntity")
    @JsonManagedReference
    private List<MessageEntity> messageEntity;

    public ChannelEntity() {
    }

    public ChannelEntity(long id, @Size(max = 255) String channel, LocalDateTime created, LocalDateTime last_modified,
            @NotNull String created_by_user, List<MessageEntity> messageEntity) {
        this.id = id;
        this.channel = channel;
        this.created = created;
        this.last_modified = last_modified;
        this.created_by_user = created_by_user;
        this.messageEntity = messageEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
    }

    public List<MessageEntity> getMessageEntity() {
        return messageEntity;
    }

    public void setMessageEntity(List<MessageEntity> messageEntity) {
        this.messageEntity = messageEntity;
    }
    
}
