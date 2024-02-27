package com.agiletech.arteria_api.form.domain.model.entity;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name ="forms")
public class Form extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Float height;

    @NotNull
    private Float weight;

    @NotNull
    private Float imc;

    @NotNull
    private Integer age;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String gender;

    @NotNull
    private Integer smoking;

    @NotNull
    private Integer alcoholism;

    @NotNull
    private Integer sedentaryLifestyle;

    @NotNull
    private Integer familyHistoryOfEcv;

    @NotNull
    private Integer diabetesMellitus;

    @NotNull
    private Integer obesity;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String bloodPressure;

    @NotNull
    private Integer coronaryCalcium;

    @NotNull
    private Integer triglycerides;

    @NotNull
    private Integer cholesterolTotal;

    @NotNull
    private Float cLDL;

    @NotNull
    private Float cHDL;

    @NotNull
    private Float cReactiveProtein;

    @NotNull
    private Integer heartRate;

    @NotNull
    private Float stSegment;

    @NotNull
    private Float qtInterval;

    @NotNull
    private Float electricShaft;

    @NotNull
    private Float rrInterval;

    @NotNull
    private Float qrsComplex;

    @NotNull
    private Float tWave;

    @NotNull
    private Float prSegmentAnomalies;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;
}
