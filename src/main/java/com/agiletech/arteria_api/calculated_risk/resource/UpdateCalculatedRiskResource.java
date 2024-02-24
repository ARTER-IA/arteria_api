package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateCalculatedRiskResource {
    @NotNull
    private Float eacProbability;

    @NotNull
    private Float heartBlockProbability;

    @NotNull
    private Float ischemiaProbability;

    @NotNull
    private Float cardiomyopathyProbability;

    @NotNull
    private Float arrhythmiasProbability;
}
