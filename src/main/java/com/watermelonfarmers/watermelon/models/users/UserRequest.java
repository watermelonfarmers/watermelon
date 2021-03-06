package com.watermelonfarmers.watermelon.models.users;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotEmpty(message = "firstName is a required field", groups = {Create.class})
    @Size(max=50, message="firstName can not be more than 50 characters", groups ={Create.class, Update.class})
    @ApiModelProperty(value = "firstName", example = "John")
    private String firstName;

    @NotEmpty(message = "lastName is a required field", groups = {Create.class})
    @Size(max=50, message="lastName can not be more than 50 characters", groups ={Create.class, Update.class})
    @ApiModelProperty(value = "lastName", example = "Snow")
    private String lastName;

    @NotEmpty(message = "userName is a required field", groups = {Create.class})
    @Size(max=20, message="userName can not be more than 20 characters", groups ={Create.class, Update.class})
    @ApiModelProperty(value = "userName", example = "admin")
    private String userName;

    @NotEmpty(message = "password is a required field", groups = {Create.class})
    @Size(max=20, message="password can not be more than 20 characters", groups ={Create.class, Update.class})
    @ApiModelProperty(value = "password", example = "admin")
    private String password;

    //@NotEmpty(message = "email is a required field", groups = {Create.class})
    @Email(message="invalid email format", groups ={Create.class, Update.class})
    @ApiModelProperty(value = "email", example = "test@test.com")
    private String email;

    public interface Create { }
    public interface Update { }

    public UserRequest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
