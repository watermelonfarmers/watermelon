package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.channels.ChannelRequest;
import com.watermelonfarmers.watermelon.models.channels.ChannelResponse;
import com.watermelonfarmers.watermelon.processors.ChannelProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ChannelResponse>> getChannels() {
        return channelProcessor.getChannels();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createChannel(@Validated(ChannelRequest.Create.class) @RequestBody ChannelRequest request) {
        return channelProcessor.createChannel(request);
    }

    @RequestMapping(value = "/{channelId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateChannel(@Validated(ChannelRequest.Update.class) @RequestBody ChannelRequest request,
                                           @PathVariable("channelId") Long channelId) {
        return channelProcessor.updateChannel(request, channelId);
    }

    @RequestMapping(value = "/{channelId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteChannel(@PathVariable("channelId") Long channelId) {
        return channelProcessor.deleteChannel(channelId);
    }
}
