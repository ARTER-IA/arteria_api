package com.agiletech.arteria_api.patient.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllergyResource {
    private Long id;
    private String description;
    private Boolean isDeleted;
    private Long patientId;
}
