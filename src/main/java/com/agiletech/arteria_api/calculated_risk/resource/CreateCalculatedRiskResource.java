package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateCalculatedRiskResource {

    @NotNull
    private Float prediction_probability;

    @NotNull
    private Float predicted_class;
}
