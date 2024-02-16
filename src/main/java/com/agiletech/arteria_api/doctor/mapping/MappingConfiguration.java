package com.agiletech.arteria_api.doctor.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("doctorMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DoctorMapper userMapper() {
        return new DoctorMapper();
    }
}
