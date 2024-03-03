package com.agiletech.arteria_api.patient.domain.persistence;

import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long>{

    List<Patient> findAllByIsDeletedIsFalse();
    Patient findByIdAndIsDeletedIsFalse(Long patientId);
    Patient findByEmailAndIsDeletedIsFalse(String email);
    List<Patient> findByFirstNameAndLastNameContainingAndIsDeletedIsFalse(String firstName, String lastName);
    @Query("SELECT p FROM Patient p WHERE p.isDeleted IS FALSE AND LOWER(p.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Patient> findByFullNameContaining(String name);
    List<Patient> findByGenderAndIsDeletedIsFalse(String gender);
    @Query("SELECT p FROM Patient p WHERE p.isDeleted = false AND p.birthdayDate BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByAgeRange(Date startDate, Date endDate);


}
