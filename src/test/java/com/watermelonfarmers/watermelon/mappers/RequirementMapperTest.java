package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RequirementMapperTest {

    public static final String TITLE = "Chaos is a ladder";
    public static final String DESCRIPTION = "Many who try to climb it fail and never get to try again";
    public static final String STATUS = "In progress";
    public static final Boolean ISARCHIVED = false;
    public static final String PRIORITY = "Normal";
    public static final UserEntity CREATEDBYUSER = new UserEntity(1L,"Arya","Stark","North","123");
    public static final UserEntity ASSIGNEDTOUSER = new UserEntity(1L,"Arya","Stark","North","123");
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

    /**
     * Mapping Entity to Model Test
     */

    @Test
    public void whenMapRequirementEntityToRequirementRequirementIdShouldBeRequirementId() {
        requirementEntity.setId(20);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getId()).isEqualTo(20);
    }

    @Test
    public void whenMapRequirementEntityToRequirementTitleShouldBeTitle() {
        requirementEntity.setTitle(TITLE);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getTitle()).isEqualTo(TITLE);
    }

    @Test
    public void whenMapRequirementEntityToRequirementDescriptionShouldBeDescription() {
        requirementEntity.setDescription(DESCRIPTION);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void whenMapRequirementEntityToRequirementStatusShouldBeStatus() {
        requirementEntity.setStatus(STATUS);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getStatus()).isEqualTo(STATUS);
    }

    @Test
    public void whenMapRequirementEntityToRequirementIsArchivedShouldBeIsArchived() {
        requirementEntity.setArchived(ISARCHIVED);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getArchived()).isEqualTo(ISARCHIVED);
    }

    @Test
    public void whenMapRequirementEntityToRequirementPriorityShouldBePriority() {
        requirementEntity.setPriority(PRIORITY);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getPriority()).isEqualTo(PRIORITY);
    }

    @Test
    public void whenMapRequirementEntityToRequirementCreatedByUserShouldBeCreatedByUser() {
        requirementEntity.setCreatedByUser(CREATEDBYUSER);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getCreatedByUser().getUserId()).isEqualTo(CREATEDBYUSER.getId());
    }

    @Test
    public void whenMapRequirementEntityToRequirementAssignedToUserShouldBeAssignedToUser() {
        requirementEntity.setAssignedToUser(ASSIGNEDTOUSER);

        requirementResponse = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);

        assertThat(requirementResponse.getAssignedToUser().getUserId()).isEqualTo(ASSIGNEDTOUSER.getId());
    }

    /**
     * Map Model to Entity Test
     */
    @Test
    public void whenMapRequirementToRequirementEntityTitleShouldBeTitle() {
        requirementRequest.setTitle(TITLE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getTitle()).isEqualTo(TITLE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityDescriptionShouldBeDescription() {
        requirementRequest.setDescription(DESCRIPTION);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void whenMapRequirementToRequirementEntityStatusShouldBeStatus() {
        requirementRequest.setStatus(STATUS);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getStatus()).isEqualTo(STATUS);
    }

    @Test
    public void whenMapRequirementToRequirementEntityIsArchivedShouldBeIsArchived() {
        requirementRequest.setArchived(ISARCHIVED);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getArchived()).isEqualTo(ISARCHIVED);
    }

    @Test
    public void whenMapRequirementToRequirementEntityPriorityShouldBePriority() {
        requirementRequest.setPriority(PRIORITY);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getPriority()).isEqualTo(PRIORITY);
    }

    @Test
    public void whenMapRequirementToRequirementEntityCreatedByUserShouldBeCreatedByUser() {
        requirementRequest.setCreatedByUser(CREATEDBYUSER.getId());

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getCreatedByUser().getId()).isEqualTo(CREATEDBYUSER.getId());
    }

    @Test
    public void whenMapRequirementToRequirementEntityAssignedToUserShouldBeAssignedToUser() {
        requirementRequest.setAssignedToUser(ASSIGNEDTOUSER.getId());

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(requirementRequest);

        assertThat(requirementEntity.getAssignedToUser().getId()).isEqualTo(ASSIGNEDTOUSER.getId());
    }


    /**
     * Mapping Model to Entity for update Test
     */
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
    public void whenMapRequirementToRequirementEntityForUpdateDescriptionShouldBeDescription() {
        requirementRequest.setDescription(DESCRIPTION);
        requirementEntity.setDescription(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndDescriptionIsNullDescriptionShouldBeOriginal() {
        requirementRequest.setDescription(null);
        requirementEntity.setDescription(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getDescription()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateStatusShouldBeStatus() {
        requirementRequest.setStatus(STATUS);
        requirementEntity.setStatus(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getStatus()).isEqualTo(STATUS);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndStatusIsNullStatusShouldBeOriginal() {
        requirementRequest.setStatus(null);
        requirementEntity.setStatus(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getStatus()).isEqualTo(ORIGINAL_VALUE);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdatePriorityShouldBePriority() {
        requirementRequest.setPriority(PRIORITY);
        requirementEntity.setPriority(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getPriority()).isEqualTo(PRIORITY);
    }

    @Test
    public void whenMapRequirementToRequirementEntityForUpdateAndPriorityIsNullPriorityShouldBeOriginal() {
        requirementRequest.setPriority(null);
        requirementEntity.setPriority(ORIGINAL_VALUE);

        requirementEntity = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity,requirementRequest);

        assertThat(requirementEntity.getPriority()).isEqualTo(ORIGINAL_VALUE);
    }

}
