package com.watermelonfarmers.watermelon.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class Message {
    @ApiModelProperty(value = "id", example = "1")
    private long id;
    @NotEmpty(message = "message is a required field", groups = { Create.class })
    @ApiModelProperty(value = "Hi", example = "Sprint 1")
    @Size(max = 255, message = "message can not be more than 255 characters", groups = { Create.class, Update.class })
    private String message;
    @ApiModelProperty(value = "created", example = "2019-02-18T20:53:58")
    private LocalDateTime created;
    @ApiModelProperty(value = "last_modified", example = "2019-02-18T20:53:58")
    private LocalDateTime last_modified;
    @NotEmpty(message = "created by user is a required field", groups = { Create.class })
    @ApiModelProperty(value = "created_by_user", example = "Hannibal")
    private String created_by_user;

    public interface Create {
    }

    public interface Update {
    }

    public Message() {
    }

    public Message(long id, String message, LocalDateTime created, LocalDateTime last_modified,
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
