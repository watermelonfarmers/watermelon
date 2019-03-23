package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.users.UserRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
public class UserRequestTest {

    private static String FIFTY_ONE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String FIFTY_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWENTY_CHARACTERS = "XXXXXXXXXXXXXXXXXXXX";
    private static String TWENTY_ONE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private UserRequest userRequest;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        initializeUser();
    }

    @Test
    public void whenFirstNameIsNullAndInterfaceIsCreateValidationFails() {
        userRequest.setFirstName(null);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName is a required field");
    }

    @Test
    public void whenFirstNameEmptyAndInterfaceIsCreateValidationFails() {
        userRequest.setFirstName("");
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName is a required field");
    }

    @Test
    public void whenFirstNameIsOverFiftyCharactersAndInterfaceIsCreateValidationFails() {
        userRequest.setFirstName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName can not be more than 50 characters");
    }

    @Test
    public void whenFirstNameIsFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        userRequest.setFirstName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenFirstNameIsOverFiftyCharactersAndInterfaceIsUpdateValidationFails() {
        userRequest.setFirstName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName can not be more than 50 characters");
    }

    @Test
    public void whenFisrtNameIsFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        userRequest.setFirstName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }


    @Test
    public void whenLastNameIsNullAndInterfaceIsCreateValidationFails() {
        userRequest.setLastName(null);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName is a required field");
    }

    @Test
    public void whenLastNameIsEmptyAndInterfaceIsCreateValidationFails() {
        userRequest.setLastName("");
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName is a required field");
    }


    @Test
    public void whenLastNameIsOverFiftyCharactersAndInterfaceIsCreateValidationFails() {
        userRequest.setLastName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName can not be more than 50 characters");
    }

    @Test
    public void whenLastNameIsFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        userRequest.setLastName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenLastNameIsOverFiftyCharactersAndInterfaceIsUpdateValidationFails() {
        userRequest.setLastName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName can not be more than 50 characters");
    }

    @Test
    public void whenLastNameIsFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        userRequest.setLastName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenUserNameIsNullAndInterfaceIsCreateValidationFails() {
        userRequest.setUserName(null);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName is a required field");
    }

    @Test
    public void whenUserNameIsEmptyAndInterfaceIsCreateValidationFails() {
        userRequest.setUserName("");
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName is a required field");
    }

    @Test
    public void whenUserNameIsOverTwentyCharactersAndInterfaceIsCreateValidationFails() {
        userRequest.setUserName(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName can not be more than 20 characters");
    }

    @Test
    public void whenUserNameIsTwentyCharactersAndInterfaceIsCreateValidationPasses() {
        userRequest.setUserName(TWENTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenUserNameIsOverTwentyCharactersAndInterfaceIsUpdateValidationFails() {
        userRequest.setUserName(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName can not be more than 20 characters");
    }

    @Test
    public void whenUserNameIsTwentyCharactersAndInterfaceIsUpdateValidationPasses() {
        userRequest.setUserName(TWENTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenPasswordIsNullAndInterfaceIsCreateValidationFails() {
        userRequest.setPassword(null);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password is a required field");
    }

    @Test
    public void whenPasswordIsEmptyAndInterfaceIsCreateValidationFails() {
        userRequest.setPassword("");
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password is a required field");
    }

    @Test
    public void whenPasswordIsOverTwentyCharactersAndInterfaceIsCreateValidationFails() {
        userRequest.setPassword(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password can not be more than 20 characters");
    }

    @Test
    public void whenPasswordIsTwentyCharactersAndInterfaceIsCreateValidationPasses() {
        userRequest.setPassword(TWENTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenPasswordIsOverTwentyCharactersAndInterfaceIsUpdateValidationFails() {
        userRequest.setPassword(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<UserRequest> violation = (ConstraintViolation<UserRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password can not be more than 20 characters");
    }

    @Test
    public void whenPasswordIsTwentyCharactersAndInterfaceIsUpdateValidationPasses() {
        userRequest.setPassword(TWENTY_CHARACTERS);
        Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest, UserRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }



    private void initializeUser() {
        userRequest = new UserRequest();
        userRequest.setFirstName("Peter");
        userRequest.setLastName("Parker");
        userRequest.setUserName("spiderman");
        userRequest.setPassword("password");
    }
}