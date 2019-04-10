package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.entities.MessageEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import com.watermelonfarmers.watermelon.models.messages.MessageResponse;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageMapperTest {

    public static final String MESSAGE = "Hello";
    public static final long MESSAGE_ID = 1l;
    public static final long CHANNEL_ID = 2l;
    public static final long USER_ID = 3l;

    private MessageRequest messageRequest;
    private MessageResponse messageResponse;
    private MessageEntity messageEntity;

    @Before
    public void setup() {
        this.messageRequest = new MessageRequest();
        this.messageResponse = new MessageResponse();
        this.messageEntity = new MessageEntity();
    }

    @Test
    public void whenMapMessageEntityToMessageIdShouldBeId() {
        messageEntity.setId(MESSAGE_ID);

        messageResponse = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);

        assertThat(messageResponse.getMessageId()).isEqualTo(MESSAGE_ID);
    }

    @Test
    public void whenMapMessageEntityToMessageFirstNameShouldBeFirstName() {
        messageEntity.setBody(MESSAGE);

        messageResponse = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);

        assertThat(messageResponse.getMessage()).isEqualTo(MESSAGE);
    }

    @Test
    public void whenMapMessageEntityToMessageCreatedShouldBeCreated() {
        LocalDateTime now = LocalDateTime.now();
        messageEntity.setCreated(now);

        messageResponse = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);

        assertThat(messageResponse.getCreated()).isEqualTo(now);
    }

    @Test
    public void whenMapMessageEntityToMessageChannelEntityIdShouldBeMappedToChannelId() {
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setChannelId(CHANNEL_ID);
        messageEntity.setChannelEntity(channelEntity);

        messageResponse = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);

        assertThat(messageResponse.getChannelId()).isEqualTo(CHANNEL_ID);
    }

    @Test
    public void whenMapMessageEntityToMessageUserEntityIdShouldBeMappedToUserId() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(USER_ID);
        messageEntity.setCreatedByUser(userEntity);

        messageResponse = MessageMapper.mapMessageEntityToMessageResponse(messageEntity);

        assertThat(messageResponse.getUser().getUserId()).isEqualTo(USER_ID);
    }

    @Test
    public void whenMapMessageRequestToMessageEntityBodyShouldBeMappedToBody() {

        messageRequest.setMessage(MESSAGE);

        messageEntity = MessageMapper.mapMessageRequestToMessageEntity(messageEntity, messageRequest);

        assertThat(messageEntity.getBody()).isEqualTo(MESSAGE);
    }

    @Test
    public void whenMapMessageRequestToMessageEntityUserIdShouldBeMappedToUserEntity() {

        messageRequest.setUserId(USER_ID);

        messageEntity = MessageMapper.mapMessageRequestToMessageEntity(messageEntity, messageRequest);

        assertThat(messageEntity.getCreatedByUser().getId()).isEqualTo(USER_ID);
    }

    @Test
    public void whenMapMessageRequestToMessageEntityChannelIdShouldBeMappedToChannelEntity() {

        messageRequest.setChannelId(CHANNEL_ID);

        messageEntity = MessageMapper.mapMessageRequestToMessageEntity(messageEntity, messageRequest);

        assertThat(messageEntity.getChannelEntity().getChannelId()).isEqualTo(CHANNEL_ID);
    }
    
}
