package com.agiletech.arteria_api.patient.domain.model.entity;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "current_conditions", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "current_conditions")
    private List<String> currentConditions;

    @NotNull
    @NotBlank
    private String profilePictureUri;

    @NotNull
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;
}
