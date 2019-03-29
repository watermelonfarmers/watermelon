package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RequirementMapperTest {

    public static final String TITLE = "Chaos is a ladder";
    public static final String DESCRIPTION = "Many who try to climb it fail and never get to try again";
    public static final String STATUS = "In progress";
    public static final String ORIGINAL_VALUE = "ORIGINAL";

    private RequirementRequest requirementRequest;
    private RequirementResponse requirementResponse;
    private RequirementEntity requirementEntity;

    @Before
    public void setup() {
        this.requirementRequest = new RequirementRequest();
        this.requirementResponse = new RequirementResponse();
        this.requirementEntity = new RequirementEntity();
    }


    @Test
    public void whenMapRequirementToRequirementEntityForUpdateTitleShouldBeTitle() {
        requirementRequest.setTitle(TITLE);
        requirementEntity.setTitle(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getTitle()).isEqualTo(TITLE);
    }


    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndTitleIsNullTitleShouldBeOriginal() {
        requirementRequest.setTitle(null);
        requirementEntity.setTitle(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getTitle()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndDescriptionIsNullDescriptionShouldBeOriginal() {
        requirementRequest.setDescription(null);
        requirementEntity.setDescription(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getDescription()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndStatusIsNullStatusShouldBeOriginal() {
        requirementRequest.setStatus(null);
        requirementEntity.setStatus(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getStatus()).isEqualTo(ORIGINAL_VALUE);
    }

}
