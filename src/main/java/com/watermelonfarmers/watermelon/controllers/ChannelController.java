package com.watermelonfarmers.watermelon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.watermelonfarmers.watermelon.models.Channel;
import com.watermelonfarmers.watermelon.processors.ChannelProcessor;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/channels")
@Api(tags = "channels", description = "channels api")
public class ChannelController {

    private ChannelProcessor channelProcessor;

    @Autowired
    public ChannelController(ChannelProcessor channelProcessor) {
        this.channelProcessor = channelProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Channel>> getChannels() {
        return channelProcessor.getChannels();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(@Validated(Channel.Create.class) @RequestBody Channel request) {
        return channelProcessor.createChannel(request);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateMessage(@Validated(Channel.Create.class) @RequestBody Channel request) {
        return channelProcessor.createChannel(request);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@Validated(Channel.Create.class) @RequestBody Channel request) {
        return channelProcessor.deleteChannel(request);
    }
}
