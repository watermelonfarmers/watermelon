package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.ActivityEntity;
import com.watermelonfarmers.watermelon.entities.RequirementEntity;
import com.watermelonfarmers.watermelon.mappers.ActivityMapper;
import com.watermelonfarmers.watermelon.mappers.RequirementMapper;
import com.watermelonfarmers.watermelon.models.Activity.ActivityRequest;
import com.watermelonfarmers.watermelon.models.Activity.ActivityResponse;
import com.watermelonfarmers.watermelon.models.requirements.RequirementResponse;
import com.watermelonfarmers.watermelon.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ActivityProcessor {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityProcessor(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ResponseEntity createActivity(ActivityRequest request) {
        ActivityEntity activityEntity = ActivityMapper.mapActivityRequestToActivityEntity(request);
        activityRepository.save(activityEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<ActivityResponse> getActivityById(Long id) {
        Optional<ActivityEntity> activityEntity = activityRepository.findById(id);
        if(activityEntity.isPresent()) {
            ActivityResponse activity = ActivityMapper.mapActivityEntityToActivityResponse(activityEntity.get());
            return new ResponseEntity<>(activity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<ActivityResponse>> readAllActivities(Long projectId) {
        Iterable<ActivityEntity> activityEntities;
        if (null != projectId) {
            activityEntities = activityRepository.findAllByProjectEntityProjectId(projectId);
        }
        else {
            activityEntities = activityRepository.findAll();
        }
        List<ActivityResponse> activities = new ArrayList<>();
        for(ActivityEntity activityEntity : activityEntities) {
            ActivityResponse activityResponse = ActivityMapper.mapActivityEntityToActivityResponse(activityEntity);
            activities.add(activityResponse);
        }
        return new ResponseEntity<>(activities,HttpStatus.OK);
    }
}
