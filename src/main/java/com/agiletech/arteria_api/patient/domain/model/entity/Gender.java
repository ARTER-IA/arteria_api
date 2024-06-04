package com.agiletech.arteria_api.patient.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Gender {
    private String name;
    private String code;
}
