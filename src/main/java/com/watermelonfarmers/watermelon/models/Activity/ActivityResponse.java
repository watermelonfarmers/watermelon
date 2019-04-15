package com.watermelonfarmers.watermelon.models.Activity;

import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.time.LocalDateTime;

public class ActivityResponse {

    private Long id;
    private LocalDateTime createdTime;
    private UserResponse user;
    private String activity;

    public ActivityResponse() {
    }

    public ActivityResponse(Long id, LocalDateTime createdTime, UserResponse user, String activity) {
        this.id = id;
        this.createdTime = createdTime;
        this.user = user;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}


