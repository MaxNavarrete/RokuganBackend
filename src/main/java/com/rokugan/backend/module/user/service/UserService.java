package com.rokugan.backend.module.user.service;

import org.springframework.stereotype.Service;

import com.rokugan.backend.module.user.entity.User;
import com.rokugan.backend.module.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void deactivateUserByUsername(String id) {
        repository.deactivateUserByUsername(id);
    }
    
}
