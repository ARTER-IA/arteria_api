package com.agiletech.arteria_api.patient.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateMedicationResource {
    @NotNull
    @NotBlank
    private String description;
}
