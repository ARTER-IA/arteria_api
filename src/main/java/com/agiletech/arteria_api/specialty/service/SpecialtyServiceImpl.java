package com.agiletech.arteria_api.specialty.service;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.domain.persistence.DoctorRepository;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.specialty.domain.model.entity.Specialty;
import com.agiletech.arteria_api.specialty.domain.persistence.SpecialtyRepository;
import com.agiletech.arteria_api.specialty.domain.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final static String ENTITY = "Specialty";

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public List<Specialty> getByDoctorId(Long doctorId) {
        return specialtyRepository.findByDoctorId(doctorId);
    }

    @Override
    public Specialty create(Specialty specialty, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + doctorId));
        specialty.setDoctor(doctor);
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty update(Long specialtyId, Specialty request) {
        return specialtyRepository.findById(specialtyId).map(specialty ->
                specialtyRepository.save(specialty
                        .withName(request.getName())
                        .withIsDeleted(request.getIsDeleted())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public ResponseEntity<?> delete(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).map(specialty -> {
            specialty.setIsDeleted(1);
            specialtyRepository.save(specialty);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }
}
