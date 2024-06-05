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

    private Float height;

    private Float weight;

    private Float imc;

    private Integer age;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String gender;

    private Integer smoking;

    private Integer alcoholism;

    private Integer sedentaryLifestyle;

    private Integer familyHistoryOfEcv;

    private Integer diabetesMellitus;

    private Integer obesity;

    @Size(max = 10)
    private String bloodPressure;

    private Integer coronaryCalcium;

    private Integer triglycerides;

    private Integer cholesterolTotal;

    private Float cLDL;

    private Float cHDL;

    private Float cReactiveProtein;

    private Integer heartRate;

    private Float stSegment;

    private Float qtInterval;

    private Float electricShaft;

    private Float rrInterval;

    private Float qrsComplex;

    private Float tWave;

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
