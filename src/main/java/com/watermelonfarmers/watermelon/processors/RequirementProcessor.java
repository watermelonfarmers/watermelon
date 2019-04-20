package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.ActivityEntity;
import com.watermelonfarmers.watermelon.entities.ProjectEntity;
import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.mappers.RequirementMapper;
import com.watermelonfarmers.watermelon.models.requirements.RequirementRequest;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.repositories.ActivityRepository;
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
    private ActivityRepository activityRepository;

    @Autowired
    public RequirementProcessor(RequirementRepository requirementRepository,ActivityRepository activityRepository) {
        this.requirementRepository = requirementRepository;
        this.activityRepository = activityRepository;
    }

    public ResponseEntity createRequirement(RequirementRequest request) {
        RequirementEntity requirementEntity = RequirementMapper.mapRequirementToRequirementEntity(request);
        requirementRepository.save(requirementEntity);

        /**
         *  Log create to activity entity
         */
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivity(" added " + request.getTitle() + " to " + request.getStatus());
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(request.getProjectId());
        activityEntity.setProjectEntity(projectEntity);
        activityEntity.setRequirement(requirementEntity);
        activityRepository.save(activityEntity);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<List<RequirementResponse>> readAllRequirement(Long projectId) {
        Iterable<RequirementEntity> requirementEntities;
        if (null != projectId) {
            requirementEntities = requirementRepository.findAllByProjectEntityProjectId(projectId);
        }
        else {
            requirementEntities = requirementRepository.findAll();
        }
        List<RequirementResponse> requirements = new ArrayList<>();
        for(RequirementEntity requirementEntity : requirementEntities) {
            RequirementResponse requirement = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity);
            requirements.add(requirement);
        }
        return new ResponseEntity<>(requirements,HttpStatus.OK);
    }

    public ResponseEntity<RequirementResponse> readOneRequirement(Long id) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(id);
        if(requirementEntity.isPresent()) {
            RequirementResponse requirement = RequirementMapper.mapRequirementEntityToRequirement(requirementEntity.get());
            return new ResponseEntity<>(requirement,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity updateRequirement(RequirementRequest request, Long requirementId) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(requirementId);
        if(requirementEntity.isPresent()) {
            RequirementEntity requirementEntityUpdated = RequirementMapper.mapRequirementToRequirementEntityForUpdate(requirementEntity.get(),request);
            requirementRepository.save(requirementEntityUpdated);

            /**
             *  Log update to activity entity
             */
            ActivityEntity activityEntity = new ActivityEntity();
            activityEntity.setActivity(" updated " + request.getTitle());
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setProjectId(request.getProjectId());
            activityEntity.setProjectEntity(projectEntity);
            activityEntity.setRequirement(requirementEntity.get());
            activityRepository.save(activityEntity);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteRequirement(Long id) {
        Optional<RequirementEntity> requirementEntity = requirementRepository.findById(id);
        if(requirementEntity.isPresent()) {
            requirementRepository.delete(requirementEntity.get());

            /**
             *  Log delete to activity entity
             */
            ActivityEntity activityEntity = new ActivityEntity();
            activityEntity.setActivity(" deleted " + requirementEntity.get().getTitle());
            activityEntity.setProjectEntity(requirementEntity.get().getProjectEntity());
            activityRepository.save(activityEntity);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
