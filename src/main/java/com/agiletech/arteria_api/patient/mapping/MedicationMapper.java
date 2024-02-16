package com.agiletech.arteria_api.patient.mapping;

import com.agiletech.arteria_api.patient.domain.model.entity.Medication;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.patient.resource.*;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class MedicationMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public MedicationResource toResource(Medication model){
        return mapper.map(model, MedicationResource.class);
    }

    public List<MedicationResource> toResource(List<Medication> model){
        return mapper.mapList(model, MedicationResource.class);
    }

    public Medication toModel(CreateMedicationResource resource){
        return mapper.map(resource, Medication.class);
    }

    public Medication toModel(UpdateMedicationResource resource){
        return mapper.map(resource, Medication.class);
    }
}
