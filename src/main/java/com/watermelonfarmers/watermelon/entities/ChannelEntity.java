package com.watermelonfarmers.watermelon.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHANNEL")
public class ChannelEntity {
    @Id
    @GeneratedValue
    @Column(name = "CHANNEL_ID", unique = true)
    private long channelId;

    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED")
    private LocalDateTime last_modified;

    @OneToMany(mappedBy = "channelEntity", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<MessageEntity> messageEntity;

    public ChannelEntity() {
    }

    public ChannelEntity(long channelId, @Size(max = 255) String name, LocalDateTime created, LocalDateTime last_modified, List<MessageEntity> messageEntity) {
        this.channelId = channelId;
        this.name = name;
        this.created = created;
        this.last_modified = last_modified;
        this.messageEntity = messageEntity;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<MessageEntity> getMessageEntity() {
        return messageEntity;
    }

    public void setMessageEntity(List<MessageEntity> messageEntity) {
        this.messageEntity = messageEntity;
    }
}
