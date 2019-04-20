package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.repositories.ActivityRepository;
import com.watermelonfarmers.watermelon.repositories.RequirementRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RequirementProcessorTest {

    public static final String ALREADY_EXISTS = "already exists";

    private RequirementProcessor requirementProcessor;

    @Mock
    private RequirementRepository requirementRepository;
    private ActivityRepository activityRepository;

    @Mock
    private RequirementEntity requirementEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        requirementProcessor = new RequirementProcessor(requirementRepository,activityRepository);
    }

    @Test
    public void whenCreateRequirementIsCalledRequirementIsCreatedAndResponseStatusCodeIsOK() {
        when(requirementRepository.save(any())).thenReturn(requirementEntity);

        ResponseEntity response = requirementProcessor.createRequirement(new RequirementRequest());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void whenReadAllRequirementIsCalledAndProjectIdIsNullAListOfRequirementsIsReturned() {
        List<RequirementEntity> requirementEntities = new ArrayList<>();
        requirementEntities.add(new RequirementEntity());
        requirementEntities.add(new RequirementEntity());
        when(requirementRepository.findAll()).thenReturn(requirementEntities);

        ResponseEntity<List<RequirementResponse>> response = requirementProcessor.readAllRequirement(null);

        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void whenReadAllRequirementIsCalledAndProjectIdIsNotNullAListOfRequirementsIsReturned() {
        List<RequirementEntity> requirementEntities = new ArrayList<>();
        requirementEntities.add(new RequirementEntity());
        requirementEntities.add(new RequirementEntity());
        when(requirementRepository.findAllByProjectEntityProjectId(any())).thenReturn(requirementEntities);

        ResponseEntity<List<RequirementResponse>> response = requirementProcessor.readAllRequirement(1l);

        assertThat(response.getBody().size()).isEqualTo(2);
    }

}