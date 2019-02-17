package com.watermelonfarmers.watermelon.models;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class Requirement {
    @ApiModelProperty(value = "id", example = "1")
    private long id;
//    @ApiModelProperty(value = "created", example = "01.01 2019")
//    private LocalDateTime created;
//    @ApiModelProperty(value = "last_modified", example = "01.01 2019")
//    private LocalDateTime last_modified;
//    @ApiModelProperty(value = "id", example = "1")
//    private long id;
//    @ApiModelProperty(value = "id", example = "1")
//    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Requirement() {
    }

}

