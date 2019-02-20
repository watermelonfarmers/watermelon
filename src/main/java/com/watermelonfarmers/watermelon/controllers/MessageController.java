package com.watermelonfarmers.watermelon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.watermelonfarmers.watermelon.models.Message;
import com.watermelonfarmers.watermelon.processors.MessageProcessor;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessageProcessor messageProcessor;

    @Autowired
    public MessageController(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getMessages() {
        return messageProcessor.getMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createMessage(@RequestBody Message request) {
        return messageProcessor.createMessage(request);
    }
    
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity updateMessage(@RequestBody Message request) {
        return messageProcessor.createMessage(request);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteMessage(@RequestBody Message request) {
        return messageProcessor.deleteMessage(request);
    }
}
