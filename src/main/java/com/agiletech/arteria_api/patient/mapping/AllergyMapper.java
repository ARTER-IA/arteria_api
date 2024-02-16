package com.agiletech.arteria_api.patient.mapping;

import com.agiletech.arteria_api.patient.domain.model.entity.Allergy;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.patient.resource.*;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AllergyMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public AllergyResource toResource(Allergy model){
        return mapper.map(model, AllergyResource.class);
    }

    public List<AllergyResource> toResource(List<Allergy> model){
        return mapper.mapList(model, AllergyResource.class);
    }

    public Allergy toModel(CreateAllergyResource resource){
        return mapper.map(resource, Allergy.class);
    }

    public Allergy toModel(UpdateAllergyResource resource){
        return mapper.map(resource, Allergy.class);
    }

}
