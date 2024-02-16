package com.agiletech.arteria_api.specialty.mapping;

import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import com.agiletech.arteria_api.specialty.domain.model.entity.Specialty;
import com.agiletech.arteria_api.specialty.resource.CreateSpecialtyResource;
import com.agiletech.arteria_api.specialty.resource.SpecialtyResource;
import com.agiletech.arteria_api.specialty.resource.UpdateSpecialtyResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SpecialtyMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public SpecialtyResource toResource(Specialty model) {
        return mapper.map(model, SpecialtyResource.class);
    }

    public List<SpecialtyResource> toResource(List<Specialty> model) {
        return mapper.mapList(model, SpecialtyResource.class);
    }

    public Specialty toModel(CreateSpecialtyResource resource) {
        return mapper.map(resource, Specialty.class);
    }

    public Specialty toModel(UpdateSpecialtyResource resource) {
        return mapper.map(resource, Specialty.class);
    }

}
