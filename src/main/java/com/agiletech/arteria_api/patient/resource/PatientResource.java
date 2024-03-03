package com.agiletech.arteria_api.patient.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
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
