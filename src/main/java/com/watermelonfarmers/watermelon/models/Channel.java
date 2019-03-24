package com.watermelonfarmers.watermelon.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.entities.MessageEntity;

import io.swagger.annotations.ApiModelProperty;

public class Channel {
    @ApiModelProperty(value = "id", example = "1")
    private long id;

    @NotEmpty(message = "channel is a required field", groups = { Create.class })
    @ApiModelProperty(value = "Hi", example = "Sprint 1")
    @Size(max = 255, message = "channel can not be more than 255 characters", groups = { Create.class, Update.class })
    private String channel;

    @ApiModelProperty(value = "created", example = "2019-02-18T20:53:58")
    private LocalDateTime created;

    @ApiModelProperty(value = "last_modified", example = "2019-02-18T20:53:58")
    private LocalDateTime last_modified;

    @NotEmpty(message = "created by user is a required field", groups = { Create.class })
    @ApiModelProperty(value = "created_by_user", example = "Hannibal")
    private String created_by_user;

    private List<MessageEntity> messages;

    public interface Create {
    }

    public interface Update {
    }

    public Channel() {
    }

    public Channel(long id,
            @NotEmpty(message = "channel is a required field", groups = Create.class) @Size(max = 255, message = "channel can not be more than 255 characters", groups = {
                    Create.class, Update.class }) String channel,
            LocalDateTime created, LocalDateTime last_modified,
            @NotEmpty(message = "created by user is a required field", groups = Create.class) String created_by_user,
            List<MessageEntity> messages) {
        super();
        this.id = id;
        this.channel = channel;
        this.created = created;
        this.last_modified = last_modified;
        this.created_by_user = created_by_user;
        this.messages = messages;
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

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

}
