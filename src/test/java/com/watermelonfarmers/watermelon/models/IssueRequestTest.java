package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.issues.IssueRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueRequestTest {

    private static String TEN_CHARS = "1234567890";
    private static String FOUR_THOUSAND_CHARS = String.join("", Collections.nCopies(400, TEN_CHARS));
    private static String FOUR_THOUSAND_PLUS_CHARS = String.join("", Collections.nCopies(401, TEN_CHARS));

    private Validator validator;

    private IssueRequest issue;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeIssue();
    }

    @Test
    public void whenIssueStepsAreNullAndInterfaceIsCreateValidationFails() {
        issue.setSteps(null);
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<IssueRequest>> iterator = violations.iterator();
        ConstraintViolation<IssueRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("issue steps is a required field");
    }

    @Test
    public void whenIssueStepsAreEmptyAndInterfaceIsCreateValidationFails() {
        issue.setSteps("");
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<IssueRequest>> iterator = violations.iterator();
        ConstraintViolation<IssueRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("issue steps is a required field");
    }

    @Test
    public void whenIssueStepsAreOverFourThousandCharactersAndInterfaceIsCreateValidationFails() {
        issue.setSteps(FOUR_THOUSAND_PLUS_CHARS);
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<IssueRequest>> iterator = violations.iterator();
        ConstraintViolation<IssueRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("issue steps can not be more than 4000 characters");
    }

    @Test
    public void whenIssueStepsAreFourThousandCharactersAndInterfaceIsCreateValidationPasses() {
        issue.setSteps(FOUR_THOUSAND_CHARS);
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenIssueStepsAreOverFourThousandCharactersAndInterfaceIsUpdateValidationFails() {
        issue.setSteps(FOUR_THOUSAND_PLUS_CHARS);
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<IssueRequest>> iterator = violations.iterator();
        ConstraintViolation<IssueRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("issue steps can not be more than 4000 characters");
    }

    @Test
    public void whenIssueStepsAreFourThousandCharactersAndInterfaceIsUpdateValidationPasses() {
        issue.setSteps(FOUR_THOUSAND_CHARS);
        Set<ConstraintViolation<IssueRequest>> violations = validator.validate(issue, IssueRequest.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeIssue() {
        issue = new IssueRequest();
        issue.setSteps("steps");
    }
}