package com.agiletech.arteria_api.form.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateFormResource {
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
}
