package com.agiletech.arteria_api.calculated_risk.domain.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getAll();
    Recommendation getById(Long recommendationId);
    Recommendation getByCalculatedRisk(Long calculatedRiskId);
    Recommendation create(Recommendation recommendation, Long calculatedRiskId);
    Recommendation update(Long recommendationId, Recommendation recommendation);
    Recommendation createWithGpt(Long calculatedRiskId);


}
