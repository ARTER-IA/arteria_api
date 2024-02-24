package com.agiletech.arteria_api.calculated_risk.domain.model.entity;

import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "calculated_risk")
public class CalculatedRisk extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Float eacProbability;

    @NotNull
    private Float heartBlockProbability;

    @NotNull
    private Float ischemiaProbability;

    @NotNull
    private Float cardiomyopathyProbability;

    @NotNull
    private Float arrhythmiasProbability;
}
