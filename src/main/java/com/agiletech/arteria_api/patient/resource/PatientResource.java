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
public class PatientResource {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private Date birthdayDate;
    private String gender;
    private String phoneNumber;
    private Float height;
    private Float weight;
    private String bloodGroup;
    private String insuranceNumber;
    private String policy;
    private String emergencyContact;
    private String emergencyPhoneNumber;
    private String profilePictureUri;
    private Boolean isDeleted;

}
