package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
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
public class RequirementRequestTest {


    private static String TWO_HUNDRED_AND_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_HUNDRED_AND_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_THOUSAND_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_THOUSAND_AND_ONE_CHARACTERS= "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private Validator validator;
    private RequirementRequest requirementRequest;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        initializeRequirement();
    }

    @Test
    public void whenTitleIsNullAndInterfaceIsCreateValidationFails() {
        requirementRequest.setTitle(null);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Title is a required field");
    }


    @Test
    public void whenTitleEmptyAndInterfaceIsCreateValidationFails() {
        requirementRequest.setTitle("");
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Title is a required field");
    }

    @Test
    public void whenTitleIsOverTwoHundredAndFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        requirementRequest.setTitle(TWO_HUNDRED_AND_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Title can not be more than 255 characters");
    }

    @Test
    public void whenDescriptionIsOverTwoThousandCharactersAndInterfaceIsCreateValidationFails() {
        requirementRequest.setDescription(TWO_THOUSAND_AND_ONE_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Description can not be more than 2000 characters");
    }

    @Test
    public void whenTitleIsTwoHundredAndFiftyFiveCharactersAndInterfaceIsCreateValidationPasses() {
        requirementRequest.setTitle(TWO_HUNDRED_AND_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenDescriptionIsTwoThousandCharactersAndInterfaceIsCreateValidationPasses() {
        requirementRequest.setDescription(TWO_THOUSAND_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Create.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenTitleIsOverTwoHundredAndFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        requirementRequest.setTitle(TWO_HUNDRED_AND_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Title can not be more than 255 characters");
    }

    @Test
    public void whenDescriptionIsOverTwoThousandCharactersAndInterfaceIsUpdateValidationFails() {
        requirementRequest.setDescription(TWO_THOUSAND_AND_ONE_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Update.class);

        assertThat(violations.size()).isEqualTo(1);
        Iterator iterator = violations.iterator();
        ConstraintViolation<RequirementRequest> violation = (ConstraintViolation<RequirementRequest>) iterator.next();
        assertThat(violation.getMessage()).isEqualTo("Description can not be more than 2000 characters");
    }

    @Test
    public void whenTitleIsTwoHundredAndFiftyFiveCharactersAndInterfaceIsUpdateValidationPasses() {
        requirementRequest.setTitle(TWO_HUNDRED_AND_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenDescriptionIsTwoThousandCharactersAndInterfaceIsUpdateValidationPasses() {
        requirementRequest.setDescription(TWO_THOUSAND_CHARACTERS);
        Set<ConstraintViolation<RequirementRequest>> violations = validator.validate(requirementRequest, RequirementRequest.Update.class);

        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeRequirement() {
        requirementRequest = new RequirementRequest();
        requirementRequest.setTitle("This is a test");
        requirementRequest.setDescription("This is a requirementRequest test");
        requirementRequest.setPriority("Regular");
        requirementRequest.setStatus("New");
        requirementRequest.setEstimatedTime("One week");
        requirementRequest.setArchived(false);
    }
}
