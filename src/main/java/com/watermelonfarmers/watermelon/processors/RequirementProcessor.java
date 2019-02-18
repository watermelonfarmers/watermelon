package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.mappers.RequirementMapper;
import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RequirementProcessor {

    private RequirementRepository requirementRepository;

    @Autowired
    public RequirementProcessor(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public ResponseEntity createRequirement(Requirement request) {
        RequirementEntity requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(request);
        requirementRepository.save(requirementEntity);
        return new ResponseEntity(HttpStatus.OK);
    }



}
