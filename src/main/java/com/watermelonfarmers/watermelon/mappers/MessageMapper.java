package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.models.Message;

public class MessageMapper {
    public static MessageEntity mapMessageEntityToMessage(Message request) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(request.getId());
        messageEntity.setMessage(request.getMessage());
        messageEntity.setCreated_by_user(request.getCreated_by_user());
        messageEntity.setCreated(request.getCreated());
        messageEntity.setLast_modified(request.getLast_modified());
        return messageEntity;
    }

    public static Message mapMessageToMessageEntity(MessageEntity messageEntity) {
        Message message = new Message();
        message.setId(messageEntity.getId());
        message.setMessage(messageEntity.getMessage());
        message.setCreated_by_user(messageEntity.getCreated_by_user());
        message.setCreated(messageEntity.getCreated());
        message.setLast_modified(messageEntity.getLast_modified());
        return message;
    }
}
