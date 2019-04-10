package com.watermelonfarmers.watermelon.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import com.watermelonfarmers.watermelon.models.channels.ChannelResponse;
import org.junit.Before;
import org.junit.Test;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;

public class ChannelMapperTest {

    public static final String MESSAGE = "Hello";

    private ChannelResponse channel;

    private ChannelEntity channelEntity;

    @Before
    public void setup() {
        this.channel = new ChannelResponse();
        this.channelEntity = new ChannelEntity();
    }

    @Test
    public void whenMapChannelEntityToChannelFirstNameShouldBeFirstName() {
        channelEntity.setName(MESSAGE);

        channel = ChannelMapper.mapChannelEntityToChannelResponse(channelEntity);

        assertThat(channel.getName()).isEqualTo(MESSAGE);
    }
    
}
