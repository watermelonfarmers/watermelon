package com.watermelonfarmers.watermelon.processors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.models.channels.ChannelRequest;
import com.watermelonfarmers.watermelon.models.channels.ChannelResponse;
import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.repositories.ChannelRepository;

public class ChannelProcessorTest {

    public static final long CHANNEL_ID = 1l;
    private ChannelProcessor channelProcessor;

    @Mock
    private ChannelRepository channelRepository;

    @Mock
    private ChannelEntity channelEntity;

    @Mock
    private ChannelRequest channelRequest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        channelProcessor = new ChannelProcessor(channelRepository);
    }

    @Test
    public void whenCreateChannelIsCalledChannelIsCreatedAndResponseStatusCodeIsOK() {
        when(channelRepository.save(any())).thenReturn(channelEntity);

        ResponseEntity<?> response = channelProcessor.createChannel(new ChannelRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenGetChannelsIsCalledAListOfChannelsIsReturned() {
        List<ChannelEntity> channelEntities = new ArrayList<>();
        channelEntities.add(new ChannelEntity());
        channelEntities.add(new ChannelEntity());
        when(channelRepository.findAll()).thenReturn(channelEntities);

        ResponseEntity<List<ChannelResponse>> response = channelProcessor.getChannels(null);

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenUpdateChannelIsCalledHttpStatusIsOK() {

        Optional<ChannelEntity> messageOptional = Optional.of(channelEntity);
        when(channelRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = channelProcessor.updateChannel(channelRequest, CHANNEL_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenUpdateMessageIsCalledAndMessageIsNotFoundHttpStatusCodeIsNotFound() {

        Optional<ChannelEntity> messageOptional = Optional.empty();
        when(channelRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = channelProcessor.updateChannel(channelRequest, CHANNEL_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenDeleteMessageIsCalledHttpStatusIsOK() {

        Optional<ChannelEntity> messageOptional = Optional.of(channelEntity);
        when(channelRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = channelProcessor.deleteChannel(CHANNEL_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenDeleteMessageIsCalledAndMessageIsNotFoundHttpStatusCodeIsNotFound() {

        Optional<ChannelEntity> messageOptional = Optional.empty();
        when(channelRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = channelProcessor.deleteChannel(CHANNEL_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
