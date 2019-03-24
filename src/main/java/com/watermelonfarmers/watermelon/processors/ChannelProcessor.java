package com.watermelonfarmers.watermelon.processors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.mappers.ChannelMapper;
import com.watermelonfarmers.watermelon.models.Channel;
import com.watermelonfarmers.watermelon.repositories.ChannelRepository;

@Service
public class ChannelProcessor {

    private ChannelRepository channelRepository;

    @Autowired
    public ChannelProcessor(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public ResponseEntity<List<Channel>> getChannels() {
        Iterable<ChannelEntity> channelEntities = channelRepository.findAll();
        List<Channel> channels = new ArrayList<>();
        for (ChannelEntity channelEntity : channelEntities) {
            Channel channel = ChannelMapper.mapChannelToChannelEntity(channelEntity);
            channels.add(channel);
        }
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    public ResponseEntity<String> createChannel(Channel request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        ChannelEntity channelEntity = ChannelMapper.mapChannelEntityToChannel(request);
        try {
            channelRepository.save(channelEntity);
        } catch (DataIntegrityViolationException ex) {
            response = new ResponseEntity<String>("already exists", HttpStatus.CONFLICT);
        }
        return response;
    }

    public ResponseEntity<String> deleteChannel(Channel request) {
        ResponseEntity<String> response = new ResponseEntity<String>("success", HttpStatus.OK);
        ChannelEntity channelEntity = ChannelMapper.mapChannelEntityToChannel(request);
        channelRepository.delete(channelEntity);
        return response;
    }
}
