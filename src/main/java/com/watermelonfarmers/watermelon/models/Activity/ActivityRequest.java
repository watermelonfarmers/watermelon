package com.watermelonfarmers.watermelon.models.Activity;

import io.swagger.annotations.ApiModelProperty;

public class ActivityRequest {
    @ApiModelProperty(value = "createdUserId", example = "1")
    private Long createdUserId;

    @ApiModelProperty(value = "action", example = "moved")
    private String action;

    @ApiModelProperty(value = "target", example = "this card")
    private String target;

    @ApiModelProperty(value = "startPoint", example = "from New Requirements")
    private String startPoint;

    @ApiModelProperty(value = "endPoint", example = "to Progress Requirements")
    private String endPoint;

    public ActivityRequest() {

    }

    public ActivityRequest(Long createdUserId, String action, String target, String startPoint, String endPoint) {
        this.createdUserId = createdUserId;
        this.action = action;
        this.target = target;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}



