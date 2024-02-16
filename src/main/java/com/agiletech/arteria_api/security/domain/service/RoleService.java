package com.agiletech.arteria_api.security.domain.service;

import com.agiletech.arteria_api.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();
    List<Role> getAll();
}
