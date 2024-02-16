package com.agiletech.arteria_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableJpaAuditing
@OpenAPIDefinition
public class ArteriaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArteriaApiApplication.class, args);
    }

}
