package com.agiletech.arteria_api.calculated_risk.mapping;


import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import com.agiletech.arteria_api.calculated_risk.resource.CalculatedRiskResource;
import com.agiletech.arteria_api.calculated_risk.resource.CreateCalculatedRiskResource;
import com.agiletech.arteria_api.calculated_risk.resource.UpdateCalculatedRiskResource;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class CalculatedRiskMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public CalculatedRiskResource toResource(CalculatedRisk model){
        return mapper.map(model, CalculatedRiskResource.class);
    }

    public List<CalculatedRiskResource> toResource(List<CalculatedRisk> model){
        return mapper.mapList(model, CalculatedRiskResource.class);
    }

    public CalculatedRisk toModel(CreateCalculatedRiskResource resource){
        return mapper.map(resource, CalculatedRisk.class);
    }

    public CalculatedRisk toModel(UpdateCalculatedRiskResource resource){
        return mapper.map(resource, CalculatedRisk.class);
    }
}
