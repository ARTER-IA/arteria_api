package com.agiletech.arteria_api.patient.domain.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Patient getById(Long patientId);
    List<Patient> getByFilters(String fullName, String gender, Integer minAge, Integer maxAge);
    Patient create(Patient patient);
    Patient update(Long patientId, Patient patient);
    Patient delete(Long patientId);
}
