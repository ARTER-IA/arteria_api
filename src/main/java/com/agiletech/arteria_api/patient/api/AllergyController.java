package com.agiletech.arteria_api.patient.api;

import com.agiletech.arteria_api.patient.domain.service.AllergyService;
import com.agiletech.arteria_api.patient.mapping.AllergyMapper;
import com.agiletech.arteria_api.patient.resource.CreateAllergyResource;
import com.agiletech.arteria_api.patient.resource.AllergyResource;
import com.agiletech.arteria_api.patient.resource.UpdateAllergyResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Allergy")
@RestController
@RequestMapping("api/v1/allergies")
@CrossOrigin()
public class AllergyController {
    @Autowired
    private AllergyService allergyService;

    @Autowired
    private AllergyMapper allergyMapper;

    @Operation(summary = "Get All Allergies", description = "Get All Allergies")
    @GetMapping()
    public List<AllergyResource> getAll(){
        return allergyMapper.toResource(allergyService.getAll());
    }

    @Operation(summary = "Get Allergy by Id", description = "Get Allergy by Id")
    @GetMapping("{allergyId}")
    public AllergyResource getAllergyById(@PathVariable Long allergyId){
        return allergyMapper.toResource(allergyService.getById(allergyId));
    }

    @Operation(summary = "Get Allergies by Patient", description = "Get Allergies By Patient Id")
    @GetMapping("{patientId}/patient")
    public List<AllergyResource> getByPatientId(@PathVariable Long patientId){
        return allergyMapper.toResource((allergyService.getByPatientId(patientId)));
    }

    @Operation(summary = "Create New Allergy", description = "Create New Allergy")
    @PostMapping("{patientId}/patient")
    public AllergyResource createAllergy(@RequestBody CreateAllergyResource model, @PathVariable Long patientId){
        return allergyMapper.toResource(allergyService.create(allergyMapper.toModel(model), patientId));
    }

    @Operation(summary = "Update Allergy", description = "Update Allergy")
    @PutMapping("{allergyId}")
    public AllergyResource updateAllergy(@PathVariable Long allergyId, @RequestBody UpdateAllergyResource model){
        return allergyMapper.toResource(allergyService.update(allergyId, allergyMapper.toModel(model)));
    }

    @Operation(summary = "Delete Allergy", description = "Delete Allergy")
    @DeleteMapping("{allergyId}")
    public AllergyResource deleteAllergy(@PathVariable Long allergyId){
        return allergyMapper.toResource(allergyService.delete(allergyId));
    }
}
