package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.processors.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserProcessor userProcessor;

    @Autowired
    public UserController(UserProcessor userProcessor) {
        this.userProcessor = userProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {

        // github work flow test

        return userProcessor.getUsers();

    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        return userProcessor.getUserByUserName(userName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@Validated(User.Create.class) @RequestBody User request) {

        return userProcessor.createUser(request);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User request, Principal user) {

        return userProcessor.updateUser(request, user);
    }

}
