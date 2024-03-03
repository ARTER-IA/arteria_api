package com.agiletech.arteria_api.calculated_risk.domain.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;

import java.util.List;

public interface CalculatedRiskService {
    List<CalculatedRisk> getAll();
    List<CalculatedRisk> getByFormId(Long formId);
    CalculatedRisk getById(Long calculatedRiskId);
    CalculatedRisk create (CalculatedRisk calculatedRisk, Long formId);
    CalculatedRisk update (Long calculatedRiskId, CalculatedRisk calculatedRisk);
}
