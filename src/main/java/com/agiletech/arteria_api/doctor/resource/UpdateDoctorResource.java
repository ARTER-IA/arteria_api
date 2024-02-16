package com.agiletech.arteria_api.doctor.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateDoctorResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max=8)
    private String dni;

    @NotNull
    private Date birthDate;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String gender;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String country;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String department;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String cmpNumber;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phone;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String workplace;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String about;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String profilePicUri;

    @NotNull
    private Integer isDeleted;

    @NotNull
    @NotBlank
    @Size(max=100)
    @Email
    private String email;
}
