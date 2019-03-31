package com.watermelonfarmers.watermelon.models.messages;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageRequest {

    @NotEmpty(message = "message is a required field", groups = { MessageRequest.Create.class })
    @Size(max = 255, message = "message can not be more than 255 characters", groups = { MessageRequest.Create.class, MessageRequest.Update.class })
    @ApiModelProperty(value = "message", example = "Hello, how are you today?")
    private String message;


    @NotNull(message = "channel id is a required field", groups = { MessageRequest.Create.class })
    @ApiModelProperty(value = "channelId", example = "1")
    private Long channelId;

    @NotNull(message = "user id is a required field", groups = { MessageRequest.Create.class })
    @ApiModelProperty(value = "userId", example = "1")
    private Long userId;

    public interface Create {
    }

    public interface Update {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
