package com.agiletech.arteria_api.specialty.api;

import com.agiletech.arteria_api.specialty.domain.service.SpecialtyService;
import com.agiletech.arteria_api.specialty.mapping.SpecialtyMapper;
import com.agiletech.arteria_api.specialty.resource.CreateSpecialtyResource;
import com.agiletech.arteria_api.specialty.resource.SpecialtyResource;
import com.agiletech.arteria_api.specialty.resource.UpdateSpecialtyResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Specialty")
@RestController
@RequestMapping("/api/v1/specialties")
@CrossOrigin
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private SpecialtyMapper mapper;

    @GetMapping
    public List<SpecialtyResource> getAllSpecialties() {
        return mapper.toResource(specialtyService.getAll());
    }

    @PostMapping("doctor/{doctorId}")
    public  SpecialtyResource createSpecialty(@PathVariable Long doctorId, @Valid @RequestBody CreateSpecialtyResource request) {
        return mapper.toResource(specialtyService.create(mapper.toModel(request),doctorId));
    }

    @GetMapping("{specialtyId}")
    public SpecialtyResource getSpecialtyById(@PathVariable Long specialtyId) {
        return mapper.toResource(specialtyService.getById(specialtyId));
    }

    @PutMapping({"{specialtyId}"})
    public SpecialtyResource updateSpecialty(@PathVariable Long specialtyId, @Valid @RequestBody UpdateSpecialtyResource request) {
        return mapper.toResource(specialtyService.update(specialtyId, mapper.toModel(request)));
    }

    @DeleteMapping("{specialtyId}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable Long specialtyId) {
        return specialtyService.delete(specialtyId);
    }

    @GetMapping("doctor/{doctorId}")
    public List<SpecialtyResource> getSpecialtyByDoctorId(@PathVariable Long doctorId) {
        return mapper.toResource(specialtyService.getByDoctorId(doctorId));
    }
}
