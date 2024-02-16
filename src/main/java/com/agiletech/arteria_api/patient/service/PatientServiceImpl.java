package com.agiletech.arteria_api.patient.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.patient.domain.persistence.PatientRepository;
import com.agiletech.arteria_api.patient.domain.service.PatientService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final static String ENTITY = "Patient";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public Patient getById(Long patientId) {
        return patientRepository.findByIdAndIsDeletedIsFalse(patientId);
    }

    @Override
    public Patient getByUsername(String username) {
        return patientRepository.findByUsernameAndIsDeletedIsFalse(username);
    }

    @Override
    public List<Patient> getByUsernameContaining(String username) {
        return patientRepository.findByUsernameContainingAndIsDeletedIsFalse(username);
    }

    /*@Override
    public List<Patient> getByFullNameContaining(String fullName) {
        return patientRepository.findByFullNameContaining(fullName);
    }

    @Override
    public List<Patient> getByAgeRange(Integer minAge, Integer maxAge) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -minAge);
        Date endDate = (Date) calendar.getTime();
        calendar.add(Calendar.YEAR, -(maxAge - minAge));
        Date startDate = (Date) calendar.getTime();
        return patientRepository.findPatientsByAgeRange(startDate, endDate);
    }

    @Override
    public List<Patient> getByGender(String gender) {
        return patientRepository.findByGenderAndIsDeletedIsFalse(gender);
    }*/

    @Override
    public List<Patient> getByFilters(String fullName, String gender, Integer minAge, Integer maxAge) {
        if (fullName != null && !fullName.isEmpty()) {
            return patientRepository.findByFullNameContaining(fullName);
        } else if (minAge != null && maxAge != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -minAge);
            Date endDate = (Date) calendar.getTime();
            calendar.add(Calendar.YEAR, -(maxAge - minAge));
            Date startDate = (Date) calendar.getTime();
            return patientRepository.findPatientsByAgeRange(startDate, endDate);
        } else if (gender != null && !gender.isEmpty()) {
            return patientRepository.findByGenderAndIsDeletedIsFalse(gender);
        } else {
            // Case when there isn't filters
            return patientRepository.findAllByIsDeletedIsFalse();
        }
    }

    @Override
    public Patient create(Patient request) {
        try {
            request.setIsDeleted(false);
            return patientRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving patient");
        }
    }

    @Override
    public Patient update(Long patientId, Patient request) {
        try {
            var patient = patientRepository.getById(patientId);
            patient.setUsername(request.getUsername());
            patient.setFirstName(request.getFirstName());
            patient.setLastName(request.getLastName());
            patient.setDni(request.getDni());
            patient.setEmail(request.getEmail());
            patient.setPassword(request.getPassword());
            patient.setBirthdayDate(request.getBirthdayDate());
            patient.setGender(request.getGender());
            patient.setPhoneNumber(request.getPhoneNumber());
            patient.setHeight(request.getHeight());
            patient.setWeight(request.getWeight());
            patient.setBloodGroup(request.getBloodGroup());
            patient.setInsuranceNumber(request.getInsuranceNumber());
            patient.setPolicy(request.getPolicy());
            patient.setEmergencyContact(request.getEmergencyContact());
            patient.setEmergencyPhoneNumber(request.getEmergencyPhoneNumber());
            patient.setProfilePictureUri(request.getProfilePictureUri());
            patient.setIsDeleted(false);
            return patientRepository.save(patient);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating patient "  + patientId);
        }
    }

    @Override
    public Patient delete(Long patientId) {
        try {
            var patient = patientRepository.getById(patientId);
            patient.setIsDeleted(true);
            return patientRepository.save(patient);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while deleting patient "  + patientId);
        }
    }
}
