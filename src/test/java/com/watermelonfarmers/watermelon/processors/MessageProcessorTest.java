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

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.models.Message;
import com.watermelonfarmers.watermelon.repositories.MessageRepository;

public class MessageProcessorTest {

    public static final String ALREADY_EXISTS = "already exists";

    private MessageProcessor messageProcessor;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageEntity messageEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        messageProcessor = new MessageProcessor(messageRepository);
    }

    @Test
    public void whenCreateMessageIsCalledMessageIsCreatedAndResponseStatusCodeIsOK() {
        when(messageRepository.save(any())).thenReturn(messageEntity);

        ResponseEntity response = messageProcessor.createMessage(new Message());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenCreateMessageIsCalledAndMessageIdAlreadyExistsResponseStatusCodeIsConflict() {
        when(messageRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = messageProcessor.createMessage(new Message());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void whenCreateMessageIsCalledAndMessageIdAlreadyExistsResponseMessageIsAlreadyExists() {
        when(messageRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity response = messageProcessor.createMessage(new Message());

        assertThat(response.getBody()).isEqualTo(ALREADY_EXISTS);
    }

    @Test
    public void whenGetMessagesIsCalledAListOfMessagesIsReturned() {
        List<MessageEntity> messageEntities = new ArrayList<>();
        messageEntities.add(new MessageEntity());
        messageEntities.add(new MessageEntity());
        when(messageRepository.findAll()).thenReturn(messageEntities);

        ResponseEntity<List<Message>> response = messageProcessor.getMessages();

        assertThat(response.getBody().size()).isEqualTo(2);
    }
}
