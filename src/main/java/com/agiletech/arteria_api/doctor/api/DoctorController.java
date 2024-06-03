package com.agiletech.arteria_api.doctor.api;

import com.agiletech.arteria_api.doctor.domain.service.DoctorService;
import com.agiletech.arteria_api.doctor.domain.service.communication.RegisterDoctorRequest;
import com.agiletech.arteria_api.doctor.mapping.DoctorMapper;
import com.agiletech.arteria_api.doctor.resource.DoctorResource;
import com.agiletech.arteria_api.doctor.resource.UpdateDoctorResource;
import com.agiletech.arteria_api.security.domain.service.communication.AuthenticateRequest;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Doctor")
@RestController
@RequestMapping("/api/v1/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;

    @GetMapping
    public List<DoctorResource> getAllDoctors() {
        return doctorMapper.modelListToResource(doctorService.getAll());
    }

    @GetMapping("{doctorId}")
    @PreAuthorize("hasRole('DOCTOR')")
    public DoctorResource getDoctorById(@PathVariable("doctorId") Long doctorId) {
        return doctorMapper.toResource(doctorService.getById(doctorId));
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> authenticateDoctor(@Valid @RequestBody AuthenticateRequest request) {
        return doctorService.authenticate(request);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> registerDoctor(@Valid @RequestBody RegisterDoctorRequest request) {
        return doctorService.register(request);
    }

    @PutMapping("{doctorId}")
    @PreAuthorize("hasRole('DOCTOR')")
    public DoctorResource updateDoctor(@PathVariable Long doctorId, @RequestBody UpdateDoctorResource request) {
        return doctorMapper.toResource(doctorService.update(doctorId, doctorMapper.toModel(request)));
    }

    @DeleteMapping("{doctorId}")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
        return doctorService.delete(doctorId);
    }
}
