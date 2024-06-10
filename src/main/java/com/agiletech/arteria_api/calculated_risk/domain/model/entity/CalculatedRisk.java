package com.agiletech.arteria_api.calculated_risk.domain.model.entity;

import com.agiletech.arteria_api.form.domain.model.entity.Form;
import com.agiletech.arteria_api.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Float prediction_probability;

    @NotNull
    private Float predicted_class;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "form_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Form form;

}
