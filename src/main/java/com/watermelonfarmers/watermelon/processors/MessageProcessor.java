package com.watermelonfarmers.watermelon.processors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.mappers.MessageMapper;
import com.watermelonfarmers.watermelon.models.Message;
import com.watermelonfarmers.watermelon.repositories.MessageRepository;

@Service
public class MessageProcessor {

    private MessageRepository messageRepository;

    @Autowired
    public MessageProcessor(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<List<Message>> getMessages() {
        Iterable<MessageEntity> messageEntities = messageRepository.findAll();
        List<Message> messages = new ArrayList<>();
        for (MessageEntity messageEntity : messageEntities) {
            Message message = MessageMapper.mapMessageToMessageEntity(messageEntity);
            messages.add(message);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    public ResponseEntity<String> createMessage(Message request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        MessageEntity messageEntity = MessageMapper.mapMessageEntityToMessage(request);
        try {
            messageRepository.save(messageEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity<String>("already exists", HttpStatus.CONFLICT);
        }
        return response;
    }

    public ResponseEntity<String> deleteMessage(Message request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        MessageEntity messageEntity = MessageMapper.mapMessageEntityToMessage(request);
        messageRepository.delete(messageEntity);
        return response;
    }
}
