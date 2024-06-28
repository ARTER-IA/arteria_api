package com.agiletech.arteria_api.calculated_risk.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
public class CalculatedRiskResource {
    private Long id;
    private Float prediction_probability;
    private Float predicted_class;
    private Long formId;
    private Date createdAt;
}
