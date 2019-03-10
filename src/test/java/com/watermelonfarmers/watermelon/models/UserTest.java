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

@SuppressWarnings("unchecked")
public class UserTest {

    private static String FIFTY_ONE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String FIFTY_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWENTY_CHARACTERS = "XXXXXXXXXXXXXXXXXXXX";
    private static String TWENTY_ONE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private User user;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        initializeUser();
    }

    @Test
    public void whenFirstNameIsNullAndInterfaceIsCreateValidationFails() {
        user.setFirstName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName is a required field");
    }

    @Test
    public void whenFirstNameIsOverFiftyCharactersAndInterfaceIsCreateValidationFails() {
        user.setFirstName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName can not be more than 50 characters");
    }

    @Test
    public void whenFirstNameIsFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        user.setFirstName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenFirstNameIsOverFiftyCharactersAndInterfaceIsUpdateValidationFails() {
        user.setFirstName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("firstName can not be more than 50 characters");
    }

    @Test
    public void whenFisrtNameIsFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        user.setFirstName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }


    @Test
    public void whenLastNameIsNullAndInterfaceIsCreateValidationFails() {
        user.setLastName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName is a required field");
    }


    @Test
    public void whenLastNameIsOverFiftyCharactersAndInterfaceIsCreateValidationFails() {
        user.setLastName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName can not be more than 50 characters");
    }

    @Test
    public void whenLastNameIsFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        user.setLastName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenLastNameIsOverFiftyCharactersAndInterfaceIsUpdateValidationFails() {
        user.setLastName(FIFTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("lastName can not be more than 50 characters");
    }

    @Test
    public void whenLastNameIsFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        user.setLastName(FIFTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenUserNameIsNullAndInterfaceIsCreateValidationFails() {
        user.setUserName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName is a required field");
    }

    @Test
    public void whenUserNameIsOverTwentyCharactersAndInterfaceIsCreateValidationFails() {
        user.setUserName(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName can not be more than 20 characters");
    }

    @Test
    public void whenUserNameIsTwentyCharactersAndInterfaceIsCreateValidationPasses() {
        user.setUserName(TWENTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenUserNameIsOverTwentyCharactersAndInterfaceIsUpdateValidationFails() {
        user.setUserName(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("userName can not be more than 20 characters");
    }

    @Test
    public void whenUserNameIsTwentyCharactersAndInterfaceIsUpdateValidationPasses() {
        user.setUserName(TWENTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenPasswordIsNullAndInterfaceIsCreateValidationFails() {
        user.setPassword(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password is a required field");
    }

    @Test
    public void whenPasswordIsOverTwentyCharactersAndInterfaceIsCreateValidationFails() {
        user.setPassword(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password can not be more than 20 characters");
    }

    @Test
    public void whenPasswordIsTwentyCharactersAndInterfaceIsCreateValidationPasses() {
        user.setPassword(TWENTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenPasswordIsOverTwentyCharactersAndInterfaceIsUpdateValidationFails() {
        user.setPassword(TWENTY_ONE_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<User> violation = (ConstraintViolation<User>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("password can not be more than 20 characters");
    }

    @Test
    public void whenPasswordIsTwentyCharactersAndInterfaceIsUpdateValidationPasses() {
        user.setPassword(TWENTY_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(user, User.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }



    private void initializeUser() {
        user = new User();
        user.setFirstName("Peter");
        user.setLastName("Parker");
        user.setUserName("spiderman");
        user.setPassword("password");
    }
}