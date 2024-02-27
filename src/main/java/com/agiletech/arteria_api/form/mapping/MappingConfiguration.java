package com.agiletech.arteria_api.form.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("formMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public FormMapper formMapper() {
        return new FormMapper();
    }
}
