package com.agiletech.arteria_api.patient.domain.model.entity;

import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "patients", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"dni"})})
public class Patient extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    private Boolean isDeleted;

}
