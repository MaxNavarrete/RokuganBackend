package com.rokugan.backend.module.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rokugan.backend.module.user.entity.User;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom  {
    
}