package com.example.nebulonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NebulonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NebulonBackendApplication.class, args);
    }

}
