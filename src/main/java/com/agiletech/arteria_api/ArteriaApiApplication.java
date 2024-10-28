package com.agiletech.arteria_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
@EnableJpaAuditing
@OpenAPIDefinition
public class ArteriaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArteriaApiApplication.class, args);
    }

    /*@EnableWebSecurity
    @AllArgsConstructor
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.cors().and().csrf().disable().
            authorizeRequests()
            .antMatchers("/api/v1/doctors/auth/**","/api/v1/doctors","/api/v1/doctors/**","/swagger-ui/**", "/v2/api-docs/**", "/swagger-resources/**", "/configuration/**").permitAll();
        }
    }*/

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/v1/**")
                    .allowedOrigins("https://arteria-prod.web.app/")
                    .allowedMethods("*")
                    .maxAge(3600L)
                    .allowedHeaders("*")
                    .exposedHeaders("Authorization")
                    .allowCredentials(true);
        }
    }

}