package com.rokugan.backend.config.MongoConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MongoConfigIntegrationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testMongoConnection() {
        // Verifica que el bean se haya creado
        assertThat(mongoTemplate).isNotNull();

        // Verifica que se puede acceder a la base
        String dbName = mongoTemplate.getDb().getName();
        System.out.println("✅ Conectado a MongoDB: " + dbName);

        assertThat(dbName).isEqualTo("rokugan_db");
    }
}