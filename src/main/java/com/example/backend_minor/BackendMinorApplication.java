package com.example.backend_minor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class BackendMinorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendMinorApplication.class, args);
    }

}
