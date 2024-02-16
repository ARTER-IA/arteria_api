package com.agiletech.arteria_api.doctor.service;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.domain.persistence.DoctorRepository;
import com.agiletech.arteria_api.doctor.domain.service.DoctorService;
import com.agiletech.arteria_api.doctor.domain.service.communication.AuthenticateDoctorResponse;
import com.agiletech.arteria_api.doctor.domain.service.communication.RegisterDoctorRequest;
import com.agiletech.arteria_api.doctor.domain.service.communication.RegisterDoctorResponse;
import com.agiletech.arteria_api.doctor.middleware.DoctorDetailsImpl;
import com.agiletech.arteria_api.doctor.middleware.JwtHandlerDoctor;
import com.agiletech.arteria_api.doctor.resource.AuthenticateDoctorResource;
import com.agiletech.arteria_api.doctor.resource.DoctorResource;
import com.agiletech.arteria_api.security.domain.model.entity.Role;
import com.agiletech.arteria_api.security.domain.model.enumeration.Roles;
import com.agiletech.arteria_api.security.domain.persistence.RoleRepository;
import com.agiletech.arteria_api.security.domain.service.communication.AuthenticateRequest;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import com.agiletech.arteria_api.shared.mapping.EnhancedModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

    private static final String ENTITY = "Doctor";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtHandlerDoctor handler;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EnhancedModelMapper mapper;

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = handler.generateToken(authentication);

            DoctorDetailsImpl doctorDetails = (DoctorDetailsImpl) authentication.getPrincipal();
            List<String> roles = doctorDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            AuthenticateDoctorResource resource = mapper.map(doctorDetails, AuthenticateDoctorResource.class);
            resource.setRoles(roles);
            resource.setToken(token);

            AuthenticateDoctorResponse response = new AuthenticateDoctorResponse(resource);

            return ResponseEntity.ok(response.getResource());
        } catch (Exception e) {
            AuthenticateDoctorResponse response = new AuthenticateDoctorResponse(String.format("An error occurred while authenticating: %s", e.getMessage()));
            return ResponseEntity.badRequest().body(response.getMessage());

        }
    }

    @Override
    public ResponseEntity<?> register(RegisterDoctorRequest request) {
        if (doctorRepository.existsByEmail(request.getEmail())) {
            AuthenticateDoctorResponse response = new AuthenticateDoctorResponse("Email is already used.");
            return ResponseEntity.badRequest()
                    .body(response.getMessage());
        }

        try {
            Set<String> rolesStringSet = request.getRoles();
            Set<Role> roles = new HashSet<>();

            if (rolesStringSet == null) {
                roleRepository.findByName(Roles.ROLE_DOCTOR)
                        .map(roles::add)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            } else {
                rolesStringSet.forEach(roleString -> roleRepository.findByName(Roles.valueOf(roleString))
                        .map(roles::add)
                        .orElseThrow(()-> new RuntimeException("Error: Role is not found.")));
            }

            logger.info("Roles: {}", roles);

            Doctor doctor = new Doctor()
                    .withUsername(request.getUsername())
                    .withFirstName(request.getFirstName())
                    .withLastName(request.getLastName())
                    .withDni(request.getDni())
                    .withBirthDate(request.getBirthDate())
                    .withGender(request.getGender())
                    .withCountry(request.getCountry())
                    .withDepartment(request.getDepartment())
                    .withAddress(request.getAddress())
                    .withCmpNumber(request.getCmpNumber())
                    .withPhone(request.getPhone())
                    .withWorkplace(request.getWorkplace())
                    .withAbout(request.getAbout())
                    .withProfilePicUri(request.getProfilePicUri())
                    .withIsDeleted(request.getIsDeleted())
                    .withEmail(request.getEmail())
                    .withPassword(encoder.encode(request.getPassword()))
                    .withRoles(roles);

            doctorRepository.save(doctor);
            DoctorResource resource = mapper.map(doctor, DoctorResource.class);
            RegisterDoctorResponse response = new RegisterDoctorResponse(resource);
            return ResponseEntity.ok(response.getResource());
        } catch (Exception e) {
            RegisterDoctorResponse response = new RegisterDoctorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(response.getMessage());
        }
    }

    @Override
    public Doctor getById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctorId));
    }

    @Override
    public Doctor update(Long doctorId, Doctor doctor) {
        try {
            return doctorRepository.findById(doctorId)
                    .map(d -> doctorRepository.save(
                            d.withUsername(doctor.getUsername())
                                    .withFirstName(doctor.getFirstName())
                                    .withLastName(doctor.getLastName())
                                    .withDni(doctor.getDni())
                                    .withBirthDate(doctor.getBirthDate())
                                    .withGender(doctor.getGender())
                                    .withCountry(doctor.getCountry())
                                    .withDepartment(doctor.getDepartment())
                                    .withAddress(doctor.getAddress())
                                    .withCmpNumber(doctor.getCmpNumber())
                                    .withPhone(doctor.getPhone())
                                    .withWorkplace(doctor.getWorkplace())
                                    .withAbout(doctor.getAbout())
                                    .withProfilePicUri(doctor.getProfilePicUri())
                                    .withIsDeleted(doctor.getIsDeleted())
                                    .withEmail(doctor.getEmail())))
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctorId));
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY,"An error occurred while updating user");
        }
    }

    /*@Override
    public ResponseEntity<?> delete(Long doctorId) {
        return doctorRepository.findById(doctorId).map(doctor -> {
            doctorRepository.delete(doctor);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctorId));
    }*/

    @Override
    public ResponseEntity<?> delete(Long doctorId) {
        return doctorRepository.findById(doctorId).map(doctor -> {
            doctor.setIsDeleted(1);
            doctorRepository.save(doctor);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctorId));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s not found", username)));
        return DoctorDetailsImpl.build(doctor);
    }
}
