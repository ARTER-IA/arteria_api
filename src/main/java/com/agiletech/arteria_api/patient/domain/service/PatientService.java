package com.agiletech.arteria_api.patient.domain.service;

import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    List<Patient> getByDoctorId(Long doctorId);
    Patient getById(Long patientId);
    List<Patient> getByFilters(String fullName, String gender, Integer minAge, Integer maxAge);
    Patient create(Patient patient, Long doctorId);
    Patient update(Long patientId, Patient patient);
    Patient delete(Long patientId);
    void uploadProfilePicture (Long patientId, MultipartFile file) throws IOException;
    byte[] getProfilePicture(Long patientId);
}
