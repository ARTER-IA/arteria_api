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

    private Integer age;

    private Integer weight;

    private Integer length;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String sex;

    private Float bmi;

    private Integer dm;

    private Integer htn;

    private Integer current_Smoker;

    private Integer ex_Smoker;

    private Integer fh;

    private Integer obesity;

    private Integer cva;

    private Integer thyroid_Disease;

    private Integer bp;

    private Integer pr;

    private Integer weak_Peripheral_Pulse;

    private Integer q_Wave;

    private Integer st_Elevation;

    private Integer st_Depression;

    private Integer tInversion;

    private Integer lvh;

    private Integer poor_R_Progression;

    private Integer tg;

    private Integer ldl;

    private Float hdl;

    private Float hb;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;
}
