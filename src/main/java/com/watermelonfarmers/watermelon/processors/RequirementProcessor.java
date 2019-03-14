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
import java.util.Optional;

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
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Requirement>> readAllRequirement() {
        Iterable<RequirementEntity> requirementEntities = requirementRepository.findAll();
        List<Requirement> requirements = new ArrayList<>();
        for(RequirementEntity requirementEntity : requirementEntities) {
            Requirement requirement = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);
            requirements.add(requirement);
        }
        return new ResponseEntity<>(requirements,HttpStatus.OK);
    }

    public ResponseEntity<Requirement> readOneRequirement(Long id) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(id);
        if(requirementEntity.isPresent()) {
            Requirement requirement = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity.get());
            return new ResponseEntity<>(requirement,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity updateRequirement(Requirement request) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(request.getId());
        if(requirementEntity.isPresent()) {
            RequirementEntity requirementEntityUpdated = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity.get(),request);
            requirementRepository.save(requirementEntityUpdated);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteRequirement(Long id) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(id);
        if(requirementEntity.isPresent()) {
            requirementRepository.delete(requirementEntity.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
