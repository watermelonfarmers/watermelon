package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import com.watermelonfarmers.watermelon.models.messages.MessageResponse;
import com.watermelonfarmers.watermelon.processors.MessageProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<MessageResponse>> getMessages() {
        return messageProcessor.getMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(@Validated(MessageRequest.Create.class) @RequestBody MessageRequest request) {
        return messageProcessor.createMessage(request);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMessage(@Validated(MessageRequest.Update.class) @RequestBody MessageRequest request,
                                           @PathVariable("messageId") Long messageId) {
        return messageProcessor.updateMessage(request, messageId);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@PathVariable("messageId") Long messageId) {
        return messageProcessor.deleteMessage(messageId);
    }

    @RequestMapping(value = "/{channel}", method = RequestMethod.GET)
    public ResponseEntity<List<MessageResponse>> getMessagesByChannel(@PathVariable("channel") Long channel) {
        return messageProcessor.getMessagesByChannel(channel);
    }
}
