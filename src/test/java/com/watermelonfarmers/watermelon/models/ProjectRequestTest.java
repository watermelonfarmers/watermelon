package com.watermelonfarmers.watermelon.models;

import com.watermelonfarmers.watermelon.models.projects.ProjectRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectRequestTest {

    private static String TWO_FIFTY_SIX_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String TWO_FIFTY_FIVE_CHARACTERS = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    private Validator validator;

    private ProjectRequest project;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        initializeProject();
    }

    @Test
    public void whenProjectIsNullAndInterfaceIsCreateValidationFails() {
        project.setProjectName(null);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ProjectRequest>> iterator = violations.iterator();
        ConstraintViolation<ProjectRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("project name is a required field");
    }

    @Test
    public void whenProjectEmptyAndInterfaceIsCreateValidationFails() {
        project.setProjectName("");
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ProjectRequest>> iterator = violations.iterator();
        ConstraintViolation<ProjectRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("project name is a required field");
    }

    @Test
    public void whenProjectIsOverTwoFiftyFiveCharactersAndInterfaceIsCreateValidationFails() {
        project.setProjectName(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ProjectRequest>> iterator = violations.iterator();
        ConstraintViolation<ProjectRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("project name can not be more than 255 characters");
    }

    @Test
    public void whenProjectIsTwoFiftyCharactersAndInterfaceIsCreateValidationPasses() {
        project.setProjectName(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenProjectIsOverTwoFiftyFiveCharactersAndInterfaceIsUpdateValidationFails() {
        project.setProjectName(TWO_FIFTY_SIX_CHARACTERS);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Update.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ProjectRequest>> iterator = violations.iterator();
        ConstraintViolation<ProjectRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("project name can not be more than 255 characters");
    }

    @Test
    public void whenProjectIsTwoFiftyCharactersAndInterfaceIsUpdateValidationPasses() {
        project.setProjectName(TWO_FIFTY_FIVE_CHARACTERS);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Update.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    public void whenUserIdIsNullAndInterfaceIsCreateValidationFails() {
        project.setProjectId(null);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(1);
        Iterator<ConstraintViolation<ProjectRequest>> iterator = violations.iterator();
        ConstraintViolation<ProjectRequest> violation = iterator.next();
        assertThat(violation.getMessage()).isEqualTo("project id is a required field");
    }
    
    @Test
    public void whenUserIdIsNotNullCharactersAndInterfaceIsCreateValidationPasses() {
        project.setProjectId(1l);
        Set<ConstraintViolation<ProjectRequest>> violations = validator.validate(project, ProjectRequest.Create.class);
        assertThat(violations.size()).isEqualTo(0);
    }

    private void initializeProject() {
        project = new ProjectRequest();
        project.setProjectId(1l);
        project.setProjectName("Watermelon");
    }
}