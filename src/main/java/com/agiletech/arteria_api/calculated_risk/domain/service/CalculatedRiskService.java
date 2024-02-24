package com.agiletech.arteria_api.calculated_risk.domain.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;

import java.util.List;

public interface CalculatedRiskService {
    List<CalculatedRisk> getAll();
    CalculatedRisk getById(Long calculatedRiskId);
    CalculatedRisk create (CalculatedRisk calculatedRisk);
    CalculatedRisk update (Long calculatedRiskId, CalculatedRisk calculatedRisk);
}
