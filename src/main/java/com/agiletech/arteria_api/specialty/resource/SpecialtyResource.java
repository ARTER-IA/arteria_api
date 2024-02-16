package com.agiletech.arteria_api.specialty.resource;

import com.agiletech.arteria_api.doctor.resource.DoctorResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialtyResource {
    private Long id;
    private String name;
    private Integer isDeleted;
    private DoctorResource doctor;
}
