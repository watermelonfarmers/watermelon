package com.watermelonfarmers.watermelon.models.channels;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ChannelRequest {

    @NotEmpty(message = "channels is a required field", groups = { ChannelRequest.Create.class })
    @ApiModelProperty(value = "name", example = "General Chat")
    @Size(max = 255, message = "channels can not be more than 255 characters", groups = { ChannelRequest.Create.class, ChannelRequest.Update.class })
    private String name;

    public interface Create {
    }

    public interface Update {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
