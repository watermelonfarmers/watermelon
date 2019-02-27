package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.mappers.RequirementMapper;
import com.watermelonfarmers.watermelon.models.Requirement;
import com.watermelonfarmers.watermelon.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<List<Requirement>> readRequirement() {
        Iterable<RequirementEntity> requirementEntities = requirementRepository.findAll();
        List<Requirement> requirements = new ArrayList<>();
        for(RequirementEntity requirementEntity : requirementEntities) {
            Requirement requirement = RequirementMapper.mapRequirmentEntityToRequirement(requirementEntity);
            requirements.add(requirement);
        }
        return new ResponseEntity<>(requirements,HttpStatus.OK);
    }

    public ResponseEntity updateRequirement(Requirement request) {
        RequirementEntity requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(request);
        requirementRepository.save(requirementEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity deleteRequirement(Requirement request) {
        RequirementEntity requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(request);
        requirementRepository.delete(requirementEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

}
