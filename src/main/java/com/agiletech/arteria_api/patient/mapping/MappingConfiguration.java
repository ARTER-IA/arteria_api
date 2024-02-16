package com.agiletech.arteria_api.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PatientMapper patientMapper(){
        return new PatientMapper();
    }

    @Bean
    public AllergyMapper allergyMapper(){
        return new AllergyMapper();
    }

    @Bean
    public MedicationMapper medicationMapper(){
        return new MedicationMapper();
    }

}
