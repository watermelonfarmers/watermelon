package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.channels.ChannelRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ChannelRequestTest {

    private static String TWO_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private ChannelRequest channel;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeChannel();
    }

    @Test
    public void whenChannelIsNullAndInterfaceIsCreateValidationFails() {
        channel.setName(null);
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ChannelRequest>> iterator = violations.iterator();
        ConstraintViolation<ChannelRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channels is a required field");
    }

    @Test
    public void whenChannelEmptyAndInterfaceIsCreateValidationFails() {
        channel.setName("");
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ChannelRequest>> iterator = violations.iterator();
        ConstraintViolation<ChannelRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channels is a required field");
    }

    @Test
    public void whenChannelIsOverTwoFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        channel.setName(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ChannelRequest>> iterator = violations.iterator();
        ConstraintViolation<ChannelRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channels can not be more than 255 characters");
    }

    @Test
    public void whenChannelIsTwoFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        channel.setName(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenChannelIsOverTwoFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        channel.setName(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ChannelRequest>> iterator = violations.iterator();
        ConstraintViolation<ChannelRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channels can not be more than 255 characters");
    }

    @Test
    public void whenChannelIsTwoFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        channel.setName(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<ChannelRequest>> violations = validator.validate(channel, ChannelRequest.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeChannel() {
        channel = new ChannelRequest();
        channel.setName("hola");
    }
}