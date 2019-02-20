package com.watermelonfarmers.watermelon.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.models.Message;

public class MessageMapperTest {

    public static final String MESSAGE = "Hello";

    private Message message;

    private MessageEntity messageEntity;

    @Before
    public void setup() {
        this.message = new Message();
        this.messageEntity = new MessageEntity();
    }

    @Test
    public void whenMapMessageEntityToMessageFirstNameShouldBeFirstName() {
        messageEntity.setMessage(MESSAGE);

        message = MessageMapper.mapMessageToMessageEntity(messageEntity);

        assertThat(message.getMessage()).isEqualTo(MESSAGE);
    }
    
}
