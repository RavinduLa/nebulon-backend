package com.example.nebulonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableMongoRepositories
public class NebulonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NebulonBackendApplication.class, args);
    }

}
