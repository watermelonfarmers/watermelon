package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.processors.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserProcessor userProcessor;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> user(Principal user)
    {
        return userProcessor.getUserByUserName(user.getName());

    }
}
