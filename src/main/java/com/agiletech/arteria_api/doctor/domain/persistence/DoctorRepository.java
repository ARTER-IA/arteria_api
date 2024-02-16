package com.agiletech.arteria_api.doctor.domain.persistence;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("select d from Doctor d where d.email = ?1")
    Optional<Doctor> findByEmail(String Email);

    Boolean existsByEmail(String email);
}
