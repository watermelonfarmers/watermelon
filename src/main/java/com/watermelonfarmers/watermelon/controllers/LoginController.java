package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.users.UserResponse;
import com.watermelonfarmers.watermelon.processors.UserProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/login")
@Api(tags = "login", description = "login api")
public class LoginController {

    @Autowired
    UserProcessor userProcessor;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserResponse> user(Principal user)
    {
        return userProcessor.getUserByUserName(user.getName());
    }
}
