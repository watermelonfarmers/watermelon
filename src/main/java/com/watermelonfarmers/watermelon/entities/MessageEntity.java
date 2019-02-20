package com.watermelonfarmers.watermelon.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "Message_body")
    private String message;
    @Column(name = "Created")
    private LocalDateTime created;
    @Column(name = "Last_modified")
    private LocalDateTime last_modified;
    @Column(name = "Created_by_user")
    private String created_by_user;

    public MessageEntity() {
    }

    public MessageEntity(long id, String message, LocalDateTime created, LocalDateTime last_modified,
            String created_by_user) {
        this.id = id;
        this.message = message;
        this.created = created;
        this.last_modified = last_modified;
        this.created_by_user = created_by_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
