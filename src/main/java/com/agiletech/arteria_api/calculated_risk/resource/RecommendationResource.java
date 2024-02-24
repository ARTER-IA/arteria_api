package com.agiletech.arteria_api.calculated_risk.resource;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationResource {
    private Long id;
    private String description;
    private Long calculatedRiskId;
}
