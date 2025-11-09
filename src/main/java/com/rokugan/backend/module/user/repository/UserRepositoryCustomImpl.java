package com.rokugan.backend.module.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.rokugan.backend.module.user.entity.User;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final MongoTemplate mongoTemplate;

   @Autowired
    public UserRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void deactivateUserById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("active", false);
        mongoTemplate.updateFirst(query, update, User.class);
    }
}