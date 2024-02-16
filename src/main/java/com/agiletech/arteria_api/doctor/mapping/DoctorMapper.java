package com.agiletech.arteria_api.doctor.mapping;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.resource.DoctorResource;
import com.agiletech.arteria_api.doctor.resource.UpdateDoctorResource;
import com.agiletech.arteria_api.security.domain.model.entity.Role;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DoctorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    Converter<Role, String> roleString = new AbstractConverter<>() {
        @Override
        protected String convert(Role role) {
            return role == null ? null : role.getName().name();
        }
    };

    public DoctorResource toResource (Doctor model) {
        mapper.addConverter(roleString);
        return mapper.map(model, DoctorResource.class);
    }

    public List<DoctorResource> modelListToResource(List<Doctor> modelList) {
        mapper.addConverter(roleString);
        return mapper.mapList(modelList, DoctorResource.class);
    }

    public Doctor toModel(UpdateDoctorResource resource) {
        return mapper.map(resource, Doctor.class);
    }

}
