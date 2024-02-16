package com.agiletech.arteria_api.specialty.domain.service;

import com.agiletech.arteria_api.specialty.domain.model.entity.Specialty;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> getAll();
    Specialty getById(Long specialtyId);
    Specialty create(Specialty specialty, Long doctorId);
    Specialty update(Long specialtyId, Specialty request);
    ResponseEntity<?> delete(Long specialtyId);
    List<Specialty> getByDoctorId(Long doctorId);

}
