package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CalculatedRiskResource {
    private Long id;
    private Float eacProbability;
    private Float heartBlockProbability;
    private Float ischemiaProbability;
    private Float cardiomyopathyProbability;
    private Float arrhythmiasProbability;
}
