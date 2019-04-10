package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.mappers.MessageMapper;
import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import com.watermelonfarmers.watermelon.models.messages.MessageResponse;
import com.watermelonfarmers.watermelon.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageProcessor {

    private MessageRepository messageRepository;

    @Autowired
    public MessageProcessor(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<List<MessageResponse>> getMessages() {
        Iterable<MessageEntity> messageEntities = messageRepository.findAll();
        return getMessageResponseListFromEntityList(messageEntities);
    }

    public ResponseEntity<?> createMessage(MessageRequest request) {
        MessageEntity messageEntity = MessageMapper.mapMessageRequestToMessageEntity(new MessageEntity(), request);
        messageRepository.save(messageEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateMessage(MessageRequest request, Long messageId) {

        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<MessageEntity> messageEntity = messageRepository.findById(messageId);
        if (messageEntity.isPresent()) {
            MessageEntity updatedMessage = MessageMapper.mapMessageRequestToMessageEntity(messageEntity.get(), request);
            messageRepository.save(updatedMessage);
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    public ResponseEntity<?> deleteMessage(Long messageId) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<MessageEntity> messageEntity = messageRepository.findById(messageId);

        if (messageEntity.isPresent()) {
            messageRepository.delete(messageEntity.get());
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }
    
    public ResponseEntity<List<MessageResponse>> getMessagesByChannel(long channelId) {
        Iterable<MessageEntity> messageEntities = messageRepository.findAllByChannelEntityChannelId(channelId);
        return getMessageResponseListFromEntityList(messageEntities);
    }

    private ResponseEntity<List<MessageResponse>> getMessageResponseListFromEntityList(Iterable<MessageEntity> messageEntities) {
        List<MessageResponse> messages = new ArrayList<>();
        for (MessageEntity messageEntity : messageEntities) {
            MessageResponse message = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);
            messages.add(message);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
