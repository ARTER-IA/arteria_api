package com.agiletech.arteria_api.specialty.domain.persistence;

import com.agiletech.arteria_api.specialty.domain.model.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    List<Specialty> findByDoctorId(Long doctorId);
}
