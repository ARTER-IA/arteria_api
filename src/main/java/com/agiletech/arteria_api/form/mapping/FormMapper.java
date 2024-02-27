package com.agiletech.arteria_api.form.mapping;

import com.agiletech.arteria_api.form.domain.model.entity.Form;
import com.agiletech.arteria_api.form.resource.CreateFormResource;
import com.agiletech.arteria_api.form.resource.FormResource;
import com.agiletech.arteria_api.form.resource.UpdateFormResource;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class FormMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public FormResource toResource(Form model) {
        return mapper.map(model, FormResource.class);
    }

    public List<FormResource> toResource(List<Form> model) {
        return mapper.mapList(model, FormResource.class);
    }

    public Form toModel(CreateFormResource resource) {
        return mapper.map(resource, Form.class);
    }

    public Form toModel(UpdateFormResource resource) {
        return mapper.map(resource, Form.class);
    }
}
