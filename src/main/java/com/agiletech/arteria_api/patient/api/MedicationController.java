package com.agiletech.arteria_api.patient.api;

import com.agiletech.arteria_api.patient.domain.service.MedicationService;
import com.agiletech.arteria_api.patient.mapping.MedicationMapper;
import com.agiletech.arteria_api.patient.resource.MedicationResource;
import com.agiletech.arteria_api.patient.resource.CreateMedicationResource;
import com.agiletech.arteria_api.patient.resource.UpdateMedicationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Medication")
@RestController
@RequestMapping("api/v1/medications")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @Autowired
    private MedicationMapper medicationMapper;

    @Operation(summary = "Get All Allergies", description = "Get All Allergies")
    @GetMapping()
    public List<MedicationResource> getAll(){
        return medicationMapper.toResource(medicationService.getAll());
    }

    @Operation(summary = "Get Medication by Id", description = "Get Medication by Id")
    @GetMapping("{medicationId}")
    public MedicationResource getMedicationById(@PathVariable Long medicationId){
        return medicationMapper.toResource(medicationService.getById(medicationId));
    }

    @Operation(summary = "Get Allergies by Patient", description = "Get Allergies By Patient Id")
    @GetMapping("{patientId}/patient")
    public List<MedicationResource> getByPatientId(@PathVariable Long patientId){
        return medicationMapper.toResource((medicationService.getByPatientId(patientId)));
    }

    @Operation(summary = "Create New Medication", description = "Create New Medication")
    @PostMapping("{patientId}/patient")
    public MedicationResource createMedication(@RequestBody CreateMedicationResource model, @PathVariable Long patientId){
        return medicationMapper.toResource(medicationService.create(medicationMapper.toModel(model), patientId));
    }

    @Operation(summary = "Update Medication", description = "Update Medication")
    @PutMapping("{medicationId}")
    public MedicationResource updateMedication(@PathVariable Long medicationId, @RequestBody UpdateMedicationResource model){
        return medicationMapper.toResource(medicationService.update(medicationId, medicationMapper.toModel(model)));
    }

    @Operation(summary = "Delete Medication", description = "Delete Medication")
    @DeleteMapping("{medicationId}")
    public MedicationResource deleteMedication(@PathVariable Long medicationId){
        return medicationMapper.toResource(medicationService.delete(medicationId));
    }
}
