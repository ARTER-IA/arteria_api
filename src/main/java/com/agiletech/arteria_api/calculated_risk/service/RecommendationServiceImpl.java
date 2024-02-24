package com.agiletech.arteria_api.calculated_risk.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import com.agiletech.arteria_api.calculated_risk.domain.model.entity.Recommendation;
import com.agiletech.arteria_api.calculated_risk.domain.persistence.CalculatedRiskRepository;
import com.agiletech.arteria_api.calculated_risk.domain.persistence.RecommendationRepository;
import com.agiletech.arteria_api.calculated_risk.domain.service.RecommendationService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final static String ENTITY = "Recommendations";

    private final static String ENTITY2 = "Calculated Risks";

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private CalculatedRiskRepository calculatedRiskRepository;

    @Override
    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

    @Override
    public Recommendation getById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
    }

    @Override
    public Recommendation getByCalculatedRisk(Long calculatedRiskId) {
        return recommendationRepository.findByCalculatedRiskId(calculatedRiskId);
    }

    @Override
    public Recommendation create(Recommendation request, Long calculatedRiskId) {
        CalculatedRisk calculatedRisk = calculatedRiskRepository.findById(calculatedRiskId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, calculatedRiskId));
        request.setCalculatedRisk(calculatedRisk);
        return recommendationRepository.save(request);
    }

    @Override
    public Recommendation update(Long recommendationId, Recommendation request) {
        try {
            Recommendation recommendation = recommendationRepository.findById(recommendationId)
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
            recommendation.setDescription(request.getDescription());
            return recommendationRepository.save(recommendation);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating recommendation"  + recommendationId);
        }
    }
}
