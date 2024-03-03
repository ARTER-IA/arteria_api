package com.agiletech.arteria_api.calculated_risk.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import com.agiletech.arteria_api.calculated_risk.domain.persistence.CalculatedRiskRepository;
import com.agiletech.arteria_api.calculated_risk.domain.service.CalculatedRiskService;
import com.agiletech.arteria_api.form.domain.model.entity.Form;
import com.agiletech.arteria_api.form.domain.persistence.FormRepository;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatedRiskServiceImpl implements CalculatedRiskService {

    private final static String ENTITY = "Calculated Risks";
    private final static String ENTITY2 = "Forms";

    @Autowired
    private CalculatedRiskRepository calculatedRiskRepository;

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<CalculatedRisk> getAll() {
        return calculatedRiskRepository.findAll();
    }

    @Override
    public List<CalculatedRisk> getByFormId(Long formId) {
        return calculatedRiskRepository.getByFormId(formId);
    }

    @Override
    public CalculatedRisk getById(Long calculatedRiskId) {
        return calculatedRiskRepository.findById(calculatedRiskId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, calculatedRiskId));
    }

    @Override
    public CalculatedRisk create(CalculatedRisk request, Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, formId));

        request.setForm(form);
        return calculatedRiskRepository.save(request);
    }

    @Override
    public CalculatedRisk update(Long calculatedRiskId, CalculatedRisk request) {
        try {
            CalculatedRisk calculatedRisk = calculatedRiskRepository.findById(calculatedRiskId)
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY, calculatedRiskId));

            calculatedRisk.setEacProbability(request.getEacProbability());
            calculatedRisk.setHeartBlockProbability(request.getHeartBlockProbability());
            calculatedRisk.setIschemiaProbability(request.getIschemiaProbability());
            calculatedRisk.setCardiomyopathyProbability(request.getCardiomyopathyProbability());
            calculatedRisk.setArrhythmiasProbability(request.getArrhythmiasProbability());

            return calculatedRiskRepository.save(calculatedRisk);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating calculated risk "  + calculatedRiskId);
        }
    }
}
