package com.agiletech.arteria_api.patient.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Allergy;
import com.agiletech.arteria_api.patient.domain.persistence.AllergyRepository;
import com.agiletech.arteria_api.patient.domain.persistence.PatientRepository;
import com.agiletech.arteria_api.patient.domain.service.AllergyService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImpl implements AllergyService {

    public final static String ENTITY = "Allergies";
    public final static String ENTITY2 = "Patients";

    @Autowired
    private AllergyRepository allergyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Allergy> getAll() {
        return allergyRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public Allergy getById(Long allergyId) {
        return allergyRepository.findByIdAndIsDeletedIsFalse(allergyId);
    }

    @Override
    public List<Allergy> getByPatientId(Long patientId) {
        return allergyRepository.findByPatientIdAndIsDeletedIsFalse(patientId);
    }

    @Override
    public Allergy create(Allergy request, Long patientId) {
        try {
            var patient = patientRepository.getById(patientId);
            request.setIsDeleted(false);
            request.setPatient(patient);
            return allergyRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving allergy");
        }
    }

    @Override
    public Allergy update(Long allergyId, Allergy request) {
        try {
            var allergy = allergyRepository.getById(allergyId);
            allergy.setDescription(request.getDescription());
            allergy.setIsDeleted(false);
            return allergyRepository.save(allergy);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating allergy " + allergyId);
        }
    }

    @Override
    public Allergy delete(Long allergyId) {
        try {
            var allergy = allergyRepository.getById(allergyId);
            allergy.setIsDeleted(true);
            return allergyRepository.save(allergy);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while deleting allergy "  + allergyId);
        }
    }
}
