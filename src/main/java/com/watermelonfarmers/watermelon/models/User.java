package com.watermelonfarmers.watermelon.models;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(value = "firstName", example = "John")
    private String firstName;
    @ApiModelProperty(value = "lastName", example = "Snow")
    private String lastName;
    @ApiModelProperty(value = "userName", example = "admin")
    private String userName;
    @ApiModelProperty(value = "password", example = "admin")
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
