package com.agiletech.arteria_api.form.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class FormResource {

    private Long id;
    private Integer age;
    private Integer weight;
    private Integer length;
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
    private Long doctorId;
    private Long patientId;
}
