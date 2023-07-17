package com.ecomos.coreconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CoreConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreConfigApplication.class, args);
    }

}
