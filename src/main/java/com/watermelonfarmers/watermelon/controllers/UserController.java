package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.User;
import com.watermelonfarmers.watermelon.processors.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return userProcessor.getUsers();

    }

//    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
//    public UserEntity getUserById(@PathVariable Long userId) {
//        //TODO
//        return null;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User request) {

        return userProcessor.createUser(request);

    }

//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@RequestBody User request) {
//        //TODO
//        return null;
//    }

}
