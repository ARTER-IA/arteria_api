package com.agiletech.arteria_api.calculated_risk.domain.persistence;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    Recommendation findByCalculatedRiskId(Long calculatedRiskId);
}
