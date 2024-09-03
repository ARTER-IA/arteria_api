package com.agiletech.arteria_api.form.domain.persistence;

import com.agiletech.arteria_api.form.domain.model.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    List<Form> findByDoctorId (Long doctorId);

    List<Form> findByPatientId (Long patientId);

    List<Form> findByDoctorIdAndPatientId (Long doctorId, Long patientId);

    Form findFirstByPatientIdOrderByCreatedAtDesc(Long patientId);
    @Query("SELECT f FROM CalculatedRisk c JOIN Form f ON c.form.id = f.id WHERE c.id = :calculatedRiskId")
    Form findByCalculatedRiskId(@Param("calculatedRiskId") Long calculatedRiskId);
}
