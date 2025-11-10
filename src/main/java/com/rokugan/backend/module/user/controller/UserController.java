package com.rokugan.backend.module.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rokugan.backend.common.response.ApiResponse;
import com.rokugan.backend.module.user.entity.User;
import com.rokugan.backend.module.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping(value = "/v1/user/deactivate/{username}")
    public ResponseEntity<Void> deactivateUser(@PathVariable String username) {
        userService.deactivateUserByUsername(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/v1/user/create")
    public ResponseEntity<ApiResponse<User>> requestMethodName(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        ApiResponse<User> response = new ApiResponse<>(true, "User created successfully", savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
