package com.agiletech.arteria_api.patient.domain.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Medication;

import java.util.List;

public interface MedicationService {
    List<Medication> getAll();
    Medication getById(Long medicationId);
    List<Medication> getByPatientId(Long patientId);
    Medication create(Medication medication, Long patientId);
    Medication update(Long medicationId, Medication medication);
    Medication delete (Long medicationId);
}
