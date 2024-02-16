package com.agiletech.arteria_api.patient.domain.persistence;

import com.agiletech.arteria_api.patient.domain.model.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findAllByIsDeletedIsFalse();
    Medication findByIdAndIsDeletedIsFalse(Long medicationId);
    List<Medication> findByPatientIdAndIsDeletedIsFalse(Long patientId);
}
