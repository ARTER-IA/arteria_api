package com.agiletech.arteria_api.doctor.domain.model.entity;

import com.agiletech.arteria_api.security.domain.model.entity.Role;
import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "doctors")
public class Doctor extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @NotBlank
    @Size(min=8,max=200)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_roles",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
