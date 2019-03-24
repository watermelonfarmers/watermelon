package com.watermelonfarmers.watermelon.processors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.models.Channel;
import com.watermelonfarmers.watermelon.repositories.ChannelRepository;

public class ChannelProcessorTest {

    public static final String ALREADY_EXISTS = "already exists";

    private ChannelProcessor channelProcessor;

    @Mock
    private ChannelRepository channelRepository;

    @Mock
    private ChannelEntity channelEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        channelProcessor = new ChannelProcessor(channelRepository);
    }

    @Test
    public void whenCreateChannelIsCalledChannelIsCreatedAndResponseStatusCodeIsOK() {
        when(channelRepository.save(any())).thenReturn(channelEntity);

        ResponseEntity<?> response = channelProcessor.createChannel(new Channel());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenCreateChannelIsCalledAndChannelIdAlreadyExistsResponseStatusCodeIsConflict() {
        when(channelRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity<?> response = channelProcessor.createChannel(new Channel());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenCreateChannelIsCalledAndChannelIdAlreadyExistsResponseChannelIsAlreadyExists() {
        when(channelRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity<?> response = channelProcessor.createChannel(new Channel());

        assertThat(response.getBody()).isEqualTo(ALREADY_EXISTS);
    }

    @Test
    public void whenGetChannelsIsCalledAListOfChannelsIsReturned() {
        List<ChannelEntity> channelEntities = new ArrayList<>();
        channelEntities.add(new ChannelEntity());
        channelEntities.add(new ChannelEntity());
        when(channelRepository.findAll()).thenReturn(channelEntities);

        ResponseEntity<List<Channel>> response = channelProcessor.getChannels();

        assertThat(response.getBody().size()).isEqualTo(2);
    }
}
