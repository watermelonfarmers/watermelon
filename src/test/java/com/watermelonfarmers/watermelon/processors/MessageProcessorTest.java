package com.watermelonfarmers.watermelon.processors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import com.watermelonfarmers.watermelon.models.messages.MessageResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.repositories.MessageRepository;

public class MessageProcessorTest {

    public static final long MESSAGE_ID = 1l;
    private MessageProcessor messageProcessor;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageEntity messageEntity;

    @Mock
    private ChannelEntity channelEntity;

    @Mock
    private MessageRequest messageRequest;

    @Mock
    private UserEntity userEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        messageProcessor = new MessageProcessor(messageRepository);
        when(messageEntity.getChannelEntity()).thenReturn(channelEntity);
        when(channelEntity.getChannelId()).thenReturn(MESSAGE_ID);
        when(messageEntity.getCreatedByUser()).thenReturn(userEntity);
    }

    @Test
    public void whenCreateMessageIsCalledMessageIsCreatedAndResponseStatusCodeIsCreated() {
        when(messageRepository.save(any())).thenReturn(messageEntity);

        ResponseEntity<?> response = messageProcessor.createMessage(messageRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void whenGetMessagesIsCalledAListOfMessagesIsReturned() {
        List<MessageEntity> messageEntities = new ArrayList<>();
        messageEntities.add(messageEntity);
        messageEntities.add(messageEntity);
        when(messageRepository.findAll()).thenReturn(messageEntities);

        ResponseEntity<List<MessageResponse>> response = messageProcessor.getMessages();

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenUpdateMessageIsCalledHttpStatusIsOK() {

        Optional<MessageEntity> messageOptional = Optional.of(messageEntity);
        when(messageRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = messageProcessor.updateMessage(messageRequest, MESSAGE_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenUpdateMessageIsCalledAndMessageIsNotFoundHttpStatusCodeIsNotFound() {

        Optional<MessageEntity> messageOptional = Optional.empty();
        when(messageRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = messageProcessor.updateMessage(messageRequest, MESSAGE_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenDeleteMessageIsCalledHttpStatusIsOK() {

        Optional<MessageEntity> messageOptional = Optional.of(messageEntity);
        when(messageRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = messageProcessor.deleteMessage(MESSAGE_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenDeleteMessageIsCalledAndMessageIsNotFoundHttpStatusCodeIsNotFound() {

        Optional<MessageEntity> messageOptional = Optional.empty();
        when(messageRepository.findById(any())).thenReturn(messageOptional);

        ResponseEntity<?> response = messageProcessor.deleteMessage(MESSAGE_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
