package com.agiletech.arteria_api.calculated_risk.domain.persistence;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatedRiskRepository extends JpaRepository <CalculatedRisk, Long> {
    List<CalculatedRisk> getByFormId(Long formId);
    CalculatedRisk findByFormId(Long formId);

    @Query("SELECT c FROM CalculatedRisk c JOIN Form f ON c.form.id = f.id WHERE f.patient.id = :patientId")
    List<CalculatedRisk> getAllByPatientId(@Param("patientId") Long patientId);


}
