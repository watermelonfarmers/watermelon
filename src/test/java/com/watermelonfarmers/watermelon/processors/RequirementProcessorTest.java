package com.watermelonfarmers.watermelon.processors;


import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.repositories.RequirementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequirementProcessorTest {

    @Autowired
    private RequirementProcessor requirementProcessor;

    @Test
    public void saveRequirementTest() {
//        RequirementEntity requirementEntity = new RequirementEntity();
//        requirementEntity.setTitle("Chaos is a ladder");
//        requirementEntity.setCreated_by_user("Little finger");
//        requirementEntity.setStatus("Done");
//        requirementEntity.setArchived(true);
//        requirementEntity.setDescription("Many who try to climb it fail and never get to try again.");

        Requirement requirement = new Requirement();
        requirement.setTitle("Chaos is a ladder");
        requirement.setCreated_by_user("Little finger");
        requirement.setStatus("Done");
        requirement.setArchived(true);
        requirement.setDescription("Many who try to climb it fail and never get to try again.");

        requirementProcessor.createRequirement(requirement);
    }
}
