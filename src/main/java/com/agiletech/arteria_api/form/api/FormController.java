package com.agiletech.arteria_api.form.api;

import com.agiletech.arteria_api.form.domain.service.FormService;
import com.agiletech.arteria_api.form.mapping.FormMapper;
import com.agiletech.arteria_api.form.resource.CreateFormResource;
import com.agiletech.arteria_api.form.resource.FormResource;
import com.agiletech.arteria_api.form.resource.UpdateFormResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Form")
@RestController
@RequestMapping("/api/v1/forms")
@CrossOrigin
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private FormMapper mapper;

    @GetMapping
    public List<FormResource> getAllForms() {
        return mapper.toResource(formService.getAll());
    }

    @GetMapping("{formId}")
    public FormResource getFormById(@PathVariable Long formId) {
        return mapper.toResource(formService.getById(formId));
    }

    @GetMapping("calculatedRisk/{calculatedRiskId}")
    public FormResource getByCalculatedRisk(@PathVariable Long calculatedRiskId){
        return mapper.toResource(formService.getByCalculatedRiskId(calculatedRiskId));
    }

    @GetMapping("/doctor/{doctorId}")
    public List<FormResource> getFormByDoctorId(@PathVariable Long doctorId) {
        return mapper.toResource(formService.getByDoctorId(doctorId));
    }

    @GetMapping("/patient/{patientId}")
    public List<FormResource> getFormByPatientId(@PathVariable Long patientId) {
        return mapper.toResource(formService.getByPatientId(patientId));
    }

    @GetMapping("/doctor/{doctorId}/patient/{patientId}")
    public List<FormResource> getFormByDoctorIdAndPatientId(@PathVariable Long doctorId, @PathVariable Long patientId) {
        return mapper.toResource(formService.getByDoctorIdAndPatientId(doctorId, patientId));
    }

    @PostMapping("doctor/{doctorId}/patient/{patientId}")
    public FormResource createForm(@PathVariable(name = "doctorId") Long doctorId,
                                   @PathVariable(name = "patientId") Long patientId,
                                   @Valid @RequestBody CreateFormResource request){
        return mapper.toResource(formService.create(mapper.toModel(request), doctorId, patientId));
    }

    @PutMapping("{formId}")
    public FormResource updateForm(@PathVariable Long formId, @Valid @RequestBody UpdateFormResource request) {
        return mapper.toResource(formService.update(formId, mapper.toModel(request)));
    }
}