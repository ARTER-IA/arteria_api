package com.agiletech.arteria_api.patient.resource;

import com.agiletech.arteria_api.patient.domain.model.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UpdatePatientResource {
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
    private Date birthdayDate;

    @Embedded
    private Gender gender;

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

    private String allergies;

    private String currentMedications;

    private String previousIllnesses;

    private String previousSurgeries;

    private List<String> currentConditions;

    @NotNull
    @NotBlank
    private String profilePictureUri;

}
