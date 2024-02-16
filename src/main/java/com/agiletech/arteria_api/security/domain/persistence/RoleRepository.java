package com.agiletech.arteria_api.security.domain.persistence;

import com.agiletech.arteria_api.security.domain.model.entity.Role;
import com.agiletech.arteria_api.security.domain.model.enumeration.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
    boolean existsByName(Roles name);
}
