package com.agiletech.arteria_api.calculated_risk.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("calculatedRiskMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CalculatedRiskMapper calculatedRiskMapper(){
        return new CalculatedRiskMapper();
    }

    @Bean
    public RecommendationMapper recommendationMapper(){
        return new RecommendationMapper();
    }
}
