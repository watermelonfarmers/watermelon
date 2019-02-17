package com.watermelonfarmers.watermelon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user)
    {
        return user;
    }
}
