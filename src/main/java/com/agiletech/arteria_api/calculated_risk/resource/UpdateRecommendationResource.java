package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateRecommendationResource {
    @NotNull
    @NotBlank
    private String description;
}
