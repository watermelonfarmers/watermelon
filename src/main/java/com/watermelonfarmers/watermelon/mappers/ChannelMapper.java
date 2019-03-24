package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.models.Channel;

public class ChannelMapper {
    public static ChannelEntity mapChannelEntityToChannel(Channel request) {
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setId(request.getId());
        channelEntity.setChannel(request.getChannel());
        channelEntity.setCreated_by_user(request.getCreated_by_user());
        channelEntity.setCreated(request.getCreated());
        channelEntity.setLast_modified(request.getLast_modified());
        return channelEntity;
    }

    public static Channel mapChannelToChannelEntity(ChannelEntity channelEntity) {
        Channel message = new Channel();
        message.setId(channelEntity.getId());
        message.setChannel(channelEntity.getChannel());
        message.setCreated_by_user(channelEntity.getCreated_by_user());
        message.setCreated(channelEntity.getCreated());
        message.setLast_modified(channelEntity.getLast_modified());
        return message;
    }
}
