package com.agiletech.arteria_api.specialty.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateSpecialtyResource {

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    @NotNull
    private Integer isDeleted;
}
