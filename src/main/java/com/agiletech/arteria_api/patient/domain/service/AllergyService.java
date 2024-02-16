package com.agiletech.arteria_api.patient.domain.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Allergy;

import java.util.List;

public interface AllergyService {
    List<Allergy> getAll();
    Allergy getById(Long allergyId);
    List<Allergy> getByPatientId(Long patientId);
    Allergy create(Allergy allergy, Long patientId);
    Allergy update(Long allergyId, Allergy allergy);
    Allergy delete (Long allergyId);
}
