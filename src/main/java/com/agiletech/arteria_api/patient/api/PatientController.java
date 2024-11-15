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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Map;

@Api(tags = "Patient")
@RestController
@RequestMapping("api/v1/patients")
@CrossOrigin
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

    @Operation(summary = "Get Patients by Doctor", description = "Get Patients by Doctor Id")
    @GetMapping("doctor/{doctorId}")
    public List<PatientResource> getByDoctorId(@PathVariable Long doctorId){
        return patientMapper.toResource(patientService.getByDoctorId(doctorId));
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

    @Operation(summary = "Get Latest Result by Patient", description = "Get Latest Result by Patient")
    @GetMapping("latestResult/{patientId}")
    public Float getLatestResultByPatient(@PathVariable Long patientId){
        return patientService.getLatestResultByPatient(patientId);
    }

    @Operation(summary = "Create New Patient", description = "Create New Patient")
    @PostMapping("doctor/{doctorId}")
    public PatientResource createPatient(@RequestBody CreatePatientResource model, @PathVariable Long doctorId){
        return patientMapper.toResource(patientService.create(patientMapper.toModel(model), doctorId));
    }

    @PostMapping("upload/{patientId}")
    public ResponseEntity<Map<String, String>> uploadProfilePicture(@PathVariable Long patientId, @RequestParam("file") MultipartFile file) {
        try {
            patientService.uploadProfilePicture(patientId, file);
            return ResponseEntity.ok(Map.of("message", "File uploaded successfully"));
        } catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("message", "File upload failed", "error", e.getMessage()));
        }
    }

    @GetMapping("profilePicture/{patientId}")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long patientId) {
        byte[] image = patientService.getProfilePicture(patientId);
        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpeg");
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
