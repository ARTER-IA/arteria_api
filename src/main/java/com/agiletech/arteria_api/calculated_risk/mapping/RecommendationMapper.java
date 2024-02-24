package com.agiletech.arteria_api.calculated_risk.mapping;


import com.agiletech.arteria_api.calculated_risk.domain.model.entity.Recommendation;
import com.agiletech.arteria_api.calculated_risk.resource.CreateRecommendationResource;
import com.agiletech.arteria_api.calculated_risk.resource.RecommendationResource;
import com.agiletech.arteria_api.calculated_risk.resource.UpdateRecommendationResource;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class RecommendationMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public RecommendationResource toResource(Recommendation model){
        return mapper.map(model, RecommendationResource.class);
    }

    public List<RecommendationResource> toResource(List<Recommendation> model){
        return mapper.mapList(model, RecommendationResource.class);
    }

    public Recommendation toModel(CreateRecommendationResource resource){
        return mapper.map(resource, Recommendation.class);
    }

    public Recommendation toModel(UpdateRecommendationResource resource){
        return mapper.map(resource, Recommendation.class);
    }
}
