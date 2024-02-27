package com.agiletech.arteria_api.form.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormResource {
    private Long id;
    private Float height;
    private Float weight;
    private Float imc;
    private Integer age;
    private String gender;
    private Integer smoking;
    private Integer alcoholism;
    private Integer sedentaryLifestyle;
    private Integer familyHistoryOfEcv;
    private Integer diabetesMellitus;
    private Integer obesity;
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
    private Long doctorId;
    private Long patientId;
}
