package com.agiletech.arteria_api.patient.api;

import com.agiletech.arteria_api.patient.domain.service.PatientService;
import com.agiletech.arteria_api.patient.mapping.PatientMapper;
import com.agiletech.arteria_api.patient.resource.CreatePatientResource;
import com.agiletech.arteria_api.patient.resource.PatientResource;
import com.agiletech.arteria_api.patient.resource.UpdatePatientResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Api(tags = "Patient")
@RestController
@RequestMapping("api/v1/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @Operation(summary = "Get All Patients", description = "Get All Patients")
    @GetMapping()
    public List<PatientResource> getAll(){
        return patientMapper.toResource(patientService.getAll());
    }

    @Operation(summary = "Get Patient by Id", description = "Get Patient by Id")
    @GetMapping("{patientId}")
    public PatientResource getPatientById(@PathVariable Long patientId){
        return patientMapper.toResource(patientService.getById(patientId));
    }

    @Operation(summary = "Get Patients by Filters", description = "Get Patients by Filters")
    @GetMapping("searchByFilters")
    public List<PatientResource> getPatientsByFilters(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        return patientMapper.toResource(patientService.getByFilters(fullName, gender, minAge, maxAge));
    }

    @Operation(summary = "Create New Patient", description = "Create New Patient")
    @PostMapping("/doctor/{doctorId}")
    public PatientResource createPatient(@RequestBody CreatePatientResource model, @PathVariable Long doctorId){
        return patientMapper.toResource(patientService.create(patientMapper.toModel(model), doctorId));
    }

    @Operation(summary = "Update Patient", description = "Update Patient")
    @PutMapping("{patientId}")
    public PatientResource updatePatient(@PathVariable Long patientId, @RequestBody UpdatePatientResource model){
        return patientMapper.toResource(patientService.update(patientId, patientMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient", description = "Delete Patient")
    @DeleteMapping("{patientId}")
    public PatientResource deletePatient(@PathVariable Long patientId){
       return patientMapper.toResource(patientService.delete(patientId));
    }

}
