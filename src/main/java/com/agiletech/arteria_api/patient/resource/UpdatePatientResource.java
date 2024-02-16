package com.agiletech.arteria_api.patient.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdatePatientResource {

    @NotNull
    @NotBlank
    @Size(max=25)
    private String username;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max=8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8,max=20)
    private String password;

    @NotNull
    private Date birthdayDate;

    @NotNull
    @NotBlank
    private String gender;

    @NotNull
    @NotBlank
    @Size(max=9)
    private String phoneNumber;

    @NotNull
    private Float height;

    @NotNull
    private Float weight;

    @NotNull
    @NotBlank
    private String bloodGroup;

    @NotNull
    @NotBlank
    private String insuranceNumber;

    @NotNull
    @NotBlank
    private String policy;

    @NotNull
    @NotBlank
    private String emergencyContact;

    @NotNull
    @NotBlank
    private String emergencyPhoneNumber;

    @NotNull
    @NotBlank
    private String profilePictureUri;

}
