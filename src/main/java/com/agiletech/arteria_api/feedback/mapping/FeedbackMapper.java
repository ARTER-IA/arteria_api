package com.agiletech.arteria_api.feedback.mapping;

import com.agiletech.arteria_api.feedback.domain.model.entity.Feedback;
import com.agiletech.arteria_api.feedback.resource.CreateFeedbackResource;
import com.agiletech.arteria_api.feedback.resource.FeedbackResource;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class FeedbackMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public FeedbackResource toResource(Feedback model){
        return mapper.map(model, FeedbackResource.class);
    }

    public List<FeedbackResource> toResource(List<Feedback> model){
        return mapper.mapList(model, FeedbackResource.class);
    }

    public Feedback toModel(CreateFeedbackResource resource){
        return mapper.map(resource, Feedback.class);
    }

}
