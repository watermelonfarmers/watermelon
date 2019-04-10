package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.messages.MessageRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageRequestTest {

    private static String TWO_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private MessageRequest message;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeMessage();
    }

    @Test
    public void whenMessageIsNullAndInterfaceIsCreateValidationFails() {
        message.setMessage(null);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message is a required field");
    }

    @Test
    public void whenMessageEmptyAndInterfaceIsCreateValidationFails() {
        message.setMessage("");
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message is a required field");
    }

    @Test
    public void whenMessageIsOverTwoFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        message.setMessage(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message can not be more than 255 characters");
    }

    @Test
    public void whenMessageIsTwoFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        message.setMessage(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenMessageIsOverTwoFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        message.setMessage(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message can not be more than 255 characters");
    }

    @Test
    public void whenMessageIsTwoFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        message.setMessage(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenUserIdIsNullAndInterfaceIsCreateValidationFails() {
        message.setUserId(null);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("user id is a required field");
    }
    
    @Test
    public void whenUserIdIsNotNullCharactersAndInterfaceIsCreateValidationPasses() {
        message.setUserId(1l);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenChannelIdIsNullAndInterfaceIsCreateValidationFails() {
        message.setChannelId(null);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<MessageRequest>> iterator = violations.iterator();
        ConstraintViolation<MessageRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("channel id is a required field");
    }

    @Test
    public void whenChannelIdIsNotNullCharactersAndInterfaceIsCreateValidationPasses() {
        message.setUserId(1l);
        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(message, MessageRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeMessage() {
        message = new MessageRequest();
        message.setMessage("hola");
        message.setUserId(1l);
        message.setChannelId(1l);
    }
}