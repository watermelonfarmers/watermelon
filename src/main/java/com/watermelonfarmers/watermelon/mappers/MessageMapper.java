package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import com.watermelonfarmers.watermelon.models.messages.MessageResponse;
import com.watermelonfarmers.watermelon.models.users.UserResponse;

public final class MessageMapper {

    public static MessageResponse mapMessageEntityToMessageResponse(MessageEntity messageEntity) {
        MessageResponse message = new MessageResponse();
        message.setMessageId(messageEntity.getId());
        message.setMessage(messageEntity.getBody());
        message.setCreated(messageEntity.getCreated());

        if (null != messageEntity.getChannelEntity()) {
            message.setChannelId(messageEntity.getChannelEntity().getChannelId());
        }

        if (null != messageEntity.getCreatedByUser()) {
            UserResponse user = UserMapper.mapUserEntityToUserResponse(messageEntity.getCreatedByUser());
            message.setUser(user);
        }

        return message;
    }

    public static MessageEntity mapMessageRequestToMessageEntity(MessageEntity messageEntity, MessageRequest request) {


        if (null != request.getMessage()) {
            messageEntity.setBody(request.getMessage());
        }

        if (null != request.getUserId()) {
            UserEntity user = new UserEntity();
            user.setId(request.getUserId());
            messageEntity.setCreatedByUser(user);
        }

        if (null != request.getChannelId()) {
            ChannelEntity channelEntity = new ChannelEntity();
            channelEntity.setChannelId(request.getChannelId());
            messageEntity.setChannelEntity(channelEntity);
        }

        return messageEntity;
    }
}
