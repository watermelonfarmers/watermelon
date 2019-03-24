package com.watermelonfarmers.watermelon.models;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ChannelTest {

    private static String TWO_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private Channel channel;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeChannel();
    }

    @Test
    public void whenChannelIsNullAndInterfaceIsCreateValidationFails() {
        channel.setChannel(null);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channel is a required field");
    }

    @Test
    public void whenChannelEmptyAndInterfaceIsCreateValidationFails() {
        channel.setChannel("");
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channel is a required field");
    }

    @Test
    public void whenChannelIsOverTwoFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        channel.setChannel(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channel can not be more than 255 characters");
    }

    @Test
    public void whenChannelIsTwoFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        channel.setChannel(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenChannelIsOverTwoFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        channel.setChannel(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channel can not be more than 255 characters");
    }

    @Test
    public void whenChannelIsTwoFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        channel.setChannel(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenCreatedByUserIsNullAndInterfaceIsCreateValidationFails() {
        channel.setCreated_by_user(null);
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("created by user is a required field");
    }
    
    @Test
    public void whenCreatedByUserIsEmptyAndInterfaceIsCreateValidationFails() {
        channel.setCreated_by_user("");
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Channel>> iterator = violations.iterator();
        ConstraintViolation<Channel> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("created by user is a required field");
    }
    
    @Test
    public void whenCreatedByUserIsNotEmptyOrNullCharactersAndInterfaceIsCreateValidationPasses() {
        channel.setCreated_by_user("doe");
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenCreatedByUserIsNotEmptyOrNullCharactersAndInterfaceIsUpdateValidationPasses() {
        channel.setCreated_by_user("doe");
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel, Channel.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeChannel() {
        channel = new Channel();
        channel.setChannel("hola");
        channel.setCreated_by_user("john");
    }
}