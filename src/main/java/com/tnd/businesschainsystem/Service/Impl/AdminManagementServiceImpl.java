package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Model.Role;
import com.tnd.businesschainsystem.Repository.RoleRepository;
import com.tnd.businesschainsystem.Service.AdminManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManagementServiceImpl implements AdminManagementService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {

        List<Role> roles = (List<Role>) roleRepository.findAll();
        return roles;
    }
}
