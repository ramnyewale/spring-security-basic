package com.spring.security.controller;

import com.spring.security.MyUserService;
import com.spring.security.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MyUserService userService;

    @PostMapping("/save")
    public MyUser createUser(@RequestBody MyUser user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public ResponseEntity<List<MyUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
