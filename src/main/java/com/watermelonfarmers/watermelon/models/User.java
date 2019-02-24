package com.watermelonfarmers.watermelon.models;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class User {

    @NotNull(
            message = "firstName is a required field",
            groups = {Create.class}
    )
    @ApiModelProperty(value = "firstName", example = "John")
    private String firstName;

    @NotNull(
            message = "lastName is a required field",
            groups = {Create.class}
    )
    @ApiModelProperty(value = "lastName", example = "Snow")
    private String lastName;

    @NotNull(
            message = "userName is a required field",
            groups = {Create.class}
    )
    @ApiModelProperty(value = "userName", example = "admin")
    private String userName;

    @NotNull(
            message = "password is a required field",
            groups = {Create.class}
    )
    @ApiModelProperty(value = "password", example = "admin")
    private String password;

    public interface Create { }

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
