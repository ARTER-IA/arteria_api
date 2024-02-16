package com.agiletech.arteria_api.security.service;

import com.agiletech.arteria_api.security.domain.model.entity.Role;
import com.agiletech.arteria_api.security.domain.model.enumeration.Roles;
import com.agiletech.arteria_api.security.domain.persistence.RoleRepository;
import com.agiletech.arteria_api.security.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private static String[] DEFAULT_ROLES = {"ROLE_DOCTOR"};

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_ROLES).forEach(name -> {
            Roles roleName = Roles.valueOf(name);
            if (!roleRepository.existsByName(roleName)) {
                roleRepository.save((new Role()).withName(roleName));
            }
        });
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
