package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.models.channels.ChannelRequest;
import com.watermelonfarmers.watermelon.models.channels.ChannelResponse;

public class ChannelMapper {
    public static ChannelEntity mapChannelRequestToChannelEntity(ChannelRequest request) {
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName(request.getName());
        return channelEntity;
    }

    public static ChannelResponse mapChannelEntityToChannelResponse(ChannelEntity channelEntity) {
        ChannelResponse channel = new ChannelResponse();
        channel.setId(channelEntity.getChannelId());
        channel.setName(channelEntity.getName());
        return channel;
    }

    public static ChannelEntity mapChannelRequestToChannelEntityForUpdate(ChannelEntity channelEntity, ChannelRequest request) {

        if (null != request.getName()) {
            channelEntity.setName(request.getName());
        }

        return channelEntity;
    }
}
