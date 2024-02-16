package com.agiletech.arteria_api.specialty.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("specialtyMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public SpecialtyMapper specialtyMapper() {
        return new SpecialtyMapper();
    }
}
