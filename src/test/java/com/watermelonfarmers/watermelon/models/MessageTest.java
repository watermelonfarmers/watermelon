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

public class MessageTest {

    private static String TWO_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private Message message;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeMessage();
    }

    @Test
    public void whenMessageIsNullAndInterfaceIsCreateValidationFails() {
        message.setMessage(null);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message is a required field");
    }

    @Test
    public void whenMessageEmptyAndInterfaceIsCreateValidationFails() {
        message.setMessage("");
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message is a required field");
    }

    @Test
    public void whenMessageIsOverTwoFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        message.setMessage(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message can not be more than 255 characters");
    }

    @Test
    public void whenMessageIsTwoFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        message.setMessage(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenMessageIsOverTwoFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        message.setMessage(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("message can not be more than 255 characters");
    }

    @Test
    public void whenMessageIsTwoFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        message.setMessage(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenCreatedByUserIsNullAndInterfaceIsCreateValidationFails() {
        message.setCreated_by_user(null);
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("created by user is a required field");
    }
    
    @Test
    public void whenCreatedByUserIsEmptyAndInterfaceIsCreateValidationFails() {
        message.setCreated_by_user("");
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<Message>> iterator = violations.iterator();
        ConstraintViolation<Message> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("created by user is a required field");
    }
    
    @Test
    public void whenCreatedByUserIsNotEmptyOrNullCharactersAndInterfaceIsCreateValidationPasses() {
        message.setCreated_by_user("doe");
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenCreatedByUserIsNotEmptyOrNullCharactersAndInterfaceIsUpdateValidationPasses() {
        message.setCreated_by_user("doe");
        Set<ConstraintViolation<Message>> violations = validator.validate(message, Message.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeMessage() {
        message = new Message();
        message.setMessage("hola");
        message.setCreated_by_user("john");
    }
}