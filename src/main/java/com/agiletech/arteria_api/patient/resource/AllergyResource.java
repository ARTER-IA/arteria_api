package com.agiletech.arteria_api.patient.resource;

import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllergyResource {
    private Long id;
    private String description;
    private Boolean isDeleted;
    private Patient patient;
}
