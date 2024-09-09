package com.agiletech.arteria_api.feedback.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("feedbackMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FeedbackMapper feedbackMapper(){
        return new FeedbackMapper();
    }
}
