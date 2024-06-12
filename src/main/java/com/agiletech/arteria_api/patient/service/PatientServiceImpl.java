package com.agiletech.arteria_api.patient.service;

import com.agiletech.arteria_api.doctor.domain.persistence.DoctorRepository;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.patient.domain.persistence.PatientRepository;
import com.agiletech.arteria_api.patient.domain.service.PatientService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final static String ENTITY = "Patient";
    private final static String ENTITY2 = "Doctor";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public List<Patient> getByDoctorId(Long doctorId) {
        return patientRepository.findAllByDoctorIdAndIsDeletedIsFalse(doctorId);
    }

    @Override
    public Patient getById(Long patientId) {
        return patientRepository.findByIdAndIsDeletedIsFalse(patientId);
    }

    @Override
    public List<Patient> getByFilters(String fullName, String gender, Integer minAge, Integer maxAge) {
        List<Patient> filteredPatients = new ArrayList<>();

        // Obtener todos los pacientes que cumplan con el filtro de nombre
        if (fullName != null && !fullName.isEmpty()) {
            filteredPatients.addAll(patientRepository.findByFullNameContaining(fullName));
        } else {
            filteredPatients.addAll(patientRepository.findAllByIsDeletedIsFalse());
        }

        // Filtrar los pacientes por género
        if (gender != null && !gender.isEmpty()) {
            filteredPatients.retainAll(patientRepository.findByGenderAndIsDeletedIsFalse(gender));
        }

        // Filtrar los pacientes por rango de edad
        if (minAge != null && maxAge != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -maxAge);
            Date startDate = calendar.getTime();
            calendar.add(Calendar.YEAR, (maxAge - minAge));
            Date endDate = calendar.getTime();

            filteredPatients.retainAll(patientRepository.findPatientsByAgeRange(startDate, endDate));
        }

        return filteredPatients;
    }

    @Override
    public Patient create(Patient request, Long doctorId) {
        try {
            var doctor = doctorRepository.findById(doctorId).
                    orElseThrow(() -> new ResourceNotFoundException(ENTITY2, doctorId));
            request.setDoctor(doctor);
            request.setIsDeleted(false);
            return patientRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving patient");
        }
    }

    @Override
    public void uploadProfilePicture(Long patientId, MultipartFile file) throws IOException {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", patientId));

        patient.setProfilePictureUri(file.getBytes());
        patientRepository.save(patient);
    }

    @Override
    public byte[] getProfilePicture(Long patientId) {
        var patient = patientRepository.findById(patientId);
        return patient.map(Patient::getProfilePictureUri).orElse(null);
    }

    @Override
    public Patient update(Long patientId, Patient request) {
        try {
            var patient = patientRepository.getById(patientId);
            patient.setFirstName(request.getFirstName());
            patient.setLastName(request.getLastName());
            patient.setDni(request.getDni());
            patient.setEmail(request.getEmail());
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
            patient.setAllergies(request.getAllergies());
            patient.setCurrentMedications(request.getCurrentMedications());
            patient.setPreviousIllnesses(request.getPreviousIllnesses());
            patient.setPreviousSurgeries(request.getPreviousSurgeries());
            patient.setCurrentConditions(request.getCurrentConditions());
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
