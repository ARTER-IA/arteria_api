package com.agiletech.arteria_api.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public RoleMapper roleMapper() {
        return new RoleMapper();
    }
}
