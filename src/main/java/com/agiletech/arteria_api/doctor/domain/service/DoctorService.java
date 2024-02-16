package com.agiletech.arteria_api.doctor.domain.service;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.domain.service.communication.RegisterDoctorRequest;
import com.agiletech.arteria_api.security.domain.service.communication.AuthenticateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DoctorService extends UserDetailsService {
    List<Doctor> getAll();
    ResponseEntity<?> authenticate(AuthenticateRequest request);
    ResponseEntity<?> register(RegisterDoctorRequest doctor);
    Doctor getById (Long doctorId);
    Doctor update (Long doctorId, Doctor doctor);
    ResponseEntity<?> delete(Long doctorId);
}
