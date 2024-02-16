package com.agiletech.arteria_api.doctor.resource;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import java.util.List;

@Getter
@Setter
public class DoctorResource {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String dni;
    private Date birthDate;
    private String gender;
    private String country;
    private String department;
    private String address;
    private String cmpNumber;
    private String phone;
    private String workplace;
    private String about;
    private String profilePicUri;
    private Integer isDeleted;
    private String email;

    private List<String> roles;
}
