package com.agiletech.arteria_api.patient.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Medication;
import com.agiletech.arteria_api.patient.domain.persistence.AllergyRepository;
import com.agiletech.arteria_api.patient.domain.persistence.MedicationRepository;
import com.agiletech.arteria_api.patient.domain.persistence.PatientRepository;
import com.agiletech.arteria_api.patient.domain.service.MedicationService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    public final static String ENTITY = "Medications";
    public final static String ENTITY2 = "Patients";

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Medication> getAll() {
        return medicationRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public Medication getById(Long medicationId) {
        return medicationRepository.findByIdAndIsDeletedIsFalse(medicationId);
    }

    @Override
    public List<Medication> getByPatientId(Long patientId) {
        return medicationRepository.findByPatientIdAndIsDeletedIsFalse(patientId);
    }

    @Override
    public Medication create(Medication request, Long patientId) {
        try {
            var patient = patientRepository.getById(patientId);
            request.setPatient(patient);
            request.setIsDeleted(false);
            return medicationRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving medication");
        }
    }

    @Override
    public Medication update(Long medicationId, Medication request) {
        try {
            var medication = medicationRepository.getById(medicationId);
            request.setDescription(medication.getDescription());
            request.setIsDeleted(false);
            return medicationRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating medication " + medicationId);
        }
    }

    @Override
    public Medication delete(Long medicationId) {
        try {
            var medication = medicationRepository.getById(medicationId);
            medication.setIsDeleted(true);
            return medicationRepository.save(medication);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while deleting medication " + medicationId);
        }
    }
}
