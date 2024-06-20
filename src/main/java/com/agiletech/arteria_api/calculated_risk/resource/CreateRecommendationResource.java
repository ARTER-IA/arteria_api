package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateRecommendationResource {
    @NotNull
    @NotBlank
    @Size(min = 10, max = 5000)
    private String description;
}
