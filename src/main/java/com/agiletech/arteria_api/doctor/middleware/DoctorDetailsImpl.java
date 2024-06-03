package com.agiletech.arteria_api.doctor.middleware;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class DoctorDetailsImpl implements UserDetails {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String dni;
    private Date birthDate;
    private String gender;
    private String country;
    private String department;
    private String address;
    private String cmpNumber;
    private String phone;
    private String workplace;
    private String about;
    private String profilePicUri;
    private Integer isDeleted;
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /*@Override
    public String getUsername() {
        return null;
    }*/

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DoctorDetailsImpl doctor  = (DoctorDetailsImpl) other;
        return Objects.equals(id, doctor.id);
    }

    public static DoctorDetailsImpl build(Doctor doctor) {
        List<GrantedAuthority> authorities = doctor.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new DoctorDetailsImpl(
                doctor.getId(),
                doctor.getUsername(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getDni(),
                doctor.getBirthDate(),
                doctor.getGender(),
                doctor.getCountry(),
                doctor.getDepartment(),
                doctor.getAddress(),
                doctor.getCmpNumber(),
                doctor.getPhone(),
                doctor.getWorkplace(),
                doctor.getAbout(),
                doctor.getProfilePicUri(),
                doctor.getIsDeleted(),
                doctor.getEmail(),
                doctor.getPassword(),
                authorities
        );
    }
}
