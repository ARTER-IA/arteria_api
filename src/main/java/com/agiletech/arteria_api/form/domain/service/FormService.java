package com.agiletech.arteria_api.form.domain.service;

import com.agiletech.arteria_api.form.domain.model.entity.Form;

import java.util.List;

public interface FormService {

    List<Form> getAll();
    Form getById(Long formId);
    Form getByCalculatedRiskId(Long calculatedRiskId);
    Form create(Form request, Long doctorId, Long patientId);
    Form update(Long formId, Form request);
    List<Form> getByDoctorId(Long doctorId);
    List<Form> getByPatientId(Long patientId);
    List<Form> getByDoctorIdAndPatientId(Long doctorId, Long patientId);

}
