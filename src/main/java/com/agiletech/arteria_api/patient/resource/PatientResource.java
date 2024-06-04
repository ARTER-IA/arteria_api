package com.agiletech.arteria_api.patient.resource;

import com.agiletech.arteria_api.patient.domain.model.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.List;

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
    private Gender gender;
    private String phoneNumber;
    private Float height;
    private Float weight;
    private String bloodGroup;
    private String insuranceNumber;
    private String policy;
    private String emergencyContact;
    private String emergencyPhoneNumber;
    private String allergies;
    private String currentMedications;
    private String previousIllnesses;
    private String previousSurgeries;
    private List<String> currentConditions;
    private String profilePictureUri;
    private Boolean isDeleted;
    private Long doctorId;
}
