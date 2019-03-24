package com.watermelonfarmers.watermelon.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.watermelonfarmers.watermelon.entities.ChannelEntity;
import com.watermelonfarmers.watermelon.models.Channel;

public class ChannelMapperTest {

    public static final String MESSAGE = "Hello";

    private Channel channel;

    private ChannelEntity channelEntity;

    @Before
    public void setup() {
        this.channel = new Channel();
        this.channelEntity = new ChannelEntity();
    }

    @Test
    public void whenMapChannelEntityToChannelFirstNameShouldBeFirstName() {
        channelEntity.setChannel(MESSAGE);

        channel = ChannelMapper.mapChannelToChannelEntity(channelEntity);

        assertThat(channel.getChannel()).isEqualTo(MESSAGE);
    }
    
}
