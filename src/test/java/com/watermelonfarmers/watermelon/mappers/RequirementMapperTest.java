package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.Requirement;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RequirementMapperTest {

    public static final String TITLE = "Chaos is a ladder";
    public static final String DESCRIPTION = "Many who try to climb it fail and never get to try again";
    public static final String STATUS = "In progress";
    public static final String ORIGINAL_VALUE = "ORIGINAL";

    private Requirement requirement;
    private RequirementEntity requirementEntity;

    @Before
    public void setup() {
        this.requirement = new Requirement();
        this.requirementEntity = new RequirementEntity();
    }


    @Test
    public void whenMapRequirementToRequirementEntityForUpdateTitleShouldBeTitle() {
        requirement.setTitle(TITLE);
        requirementEntity.setTitle(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirement);

        assertThat(requirementEntity.getTitle()).isEqualTo(TITLE);
    }


    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndTitleIsNullTitleShouldBeOriginal() {
        requirement.setTitle(null);
        requirementEntity.setTitle(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirement);

        assertThat(requirementEntity.getTitle()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndDescriptionIsNullDescriptionShouldBeOriginal() {
        requirement.setDescription(null);
        requirementEntity.setDescription(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirement);

        assertThat(requirementEntity.getDescription()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndStatusIsNullStatusShouldBeOriginal() {
        requirement.setStatus(null);
        requirementEntity.setStatus(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirement);

        assertThat(requirementEntity.getStatus()).isEqualTo(ORIGINAL_VALUE);
    }

}
