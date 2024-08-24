package com.spring.security.controller;

import com.spring.security.MyUserService;
import com.spring.security.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserService userService;

    @PostMapping("/save")
    public MyUser createUser(@RequestBody MyUser user) {
        return userService.saveUser(user);
    }
}
