package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.entities.IssueEntity;
import com.watermelonfarmers.watermelon.mappers.ChannelMapper;
import com.watermelonfarmers.watermelon.models.channels.ChannelRequest;
import com.watermelonfarmers.watermelon.models.channels.ChannelResponse;
import com.watermelonfarmers.watermelon.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelProcessor {

    private ChannelRepository channelRepository;

    @Autowired
    public ChannelProcessor(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public ResponseEntity<List<ChannelResponse>> getChannels(Long projectId) {
        Iterable<ChannelEntity> channelEntities;
        if (null != projectId) {
            channelEntities = channelRepository.findAllByProjectEntityProjectId(projectId);
        }
        else {
            channelEntities = channelRepository.findAll();
        }
        List<ChannelResponse> channels = new ArrayList<>();
        for (ChannelEntity channelEntity : channelEntities) {
            ChannelResponse channel = ChannelMapper.mapChannelEntityToChannelResponse(channelEntity);
            channels.add(channel);
        }
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    public ResponseEntity<?> createChannel(ChannelRequest request) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        ChannelEntity channelEntity = ChannelMapper.mapChannelRequestToChannelEntity(request);
        channelRepository.save(channelEntity);
        return response;
    }

    public ResponseEntity<?> deleteChannel(Long channelId) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<ChannelEntity> channelEntity = channelRepository.findById(channelId);

        if (channelEntity.isPresent()) {
            channelRepository.delete(channelEntity.get());
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    public ResponseEntity<?> updateChannel(ChannelRequest request, Long channelId) {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        Optional<ChannelEntity> channelEntity = channelRepository.findById(channelId);
        if (channelEntity.isPresent()) {
            ChannelEntity updatedChannel = ChannelMapper.mapChannelRequestToChannelEntityForUpdate(channelEntity.get(), request);
            channelRepository.save(updatedChannel);
        }
        else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
