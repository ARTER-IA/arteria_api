package com.agiletech.arteria_api.doctor.resource;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class AuthenticateDoctorResource {
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
    private Integer isDeleted;
    private String email;

    private List<String> roles;
    private String token;
}
