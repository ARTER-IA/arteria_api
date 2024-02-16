package com.agiletech.arteria_api.patient.domain.persistence;

import com.agiletech.arteria_api.patient.domain.model.entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends JpaRepository <Allergy, Long> {
    List<Allergy> findAllByIsDeletedIsFalse();
    Allergy findByIdAndIsDeletedIsFalse(Long patientId);
    List<Allergy> findByPatientIdAndIsDeletedIsFalse(Long patientId);
}
