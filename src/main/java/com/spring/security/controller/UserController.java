package com.spring.security.controller;

import com.spring.security.MyUserService;
import com.spring.security.model.AuthenticationResponse;
import com.spring.security.model.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final MyUserService userService;

    public UserController(MyUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> createUser(@RequestBody MyUser user) {
        AuthenticationResponse response = userService.saveUser(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody MyUser user) {
        return ResponseEntity.ok(userService.authenticate(user));
    }

    @GetMapping
    public ResponseEntity<List<MyUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
