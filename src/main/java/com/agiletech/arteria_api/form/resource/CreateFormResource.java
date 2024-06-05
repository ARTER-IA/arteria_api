package com.agiletech.arteria_api.form.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateFormResource {

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
}
