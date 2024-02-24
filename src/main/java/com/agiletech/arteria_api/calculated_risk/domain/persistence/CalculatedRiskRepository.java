package com.agiletech.arteria_api.calculated_risk.domain.persistence;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatedRiskRepository extends JpaRepository <CalculatedRisk, Long> {
}
