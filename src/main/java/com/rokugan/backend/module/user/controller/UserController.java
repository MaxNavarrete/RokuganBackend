package com.rokugan.backend.module.user.controller;

import com.mongodb.DuplicateKeyException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rokugan.backend.module.user.entity.User;
import com.rokugan.backend.module.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping(value = "/v1/deactivate-user/{id}")
    public void deactivateUser(@PathVariable String id) {
        userService.deactivateUserById(id);
    }

    @PostMapping("/v1/create-user")
    public ResponseEntity<?> requestMethodName(@RequestBody User user) {
        try{
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch (DuplicateKeyException | DataIntegrityViolationException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "El username o email ya existe");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }
    
}
