package com.watermelonfarmers.watermelon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.watermelonfarmers.watermelon.models.Message;
import com.watermelonfarmers.watermelon.processors.MessageProcessor;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/messages")
@Api(tags = "messages", description = "messages api")
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
    public ResponseEntity<?> createMessage(@Validated(Message.Create.class) @RequestBody Message request) {
        return messageProcessor.createMessage(request);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateMessage(@Validated(Message.Create.class) @RequestBody Message request) {
        return messageProcessor.createMessage(request);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@Validated(Message.Create.class) @RequestBody Message request) {
        return messageProcessor.deleteMessage(request);
    }
}
