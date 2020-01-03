package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Model.DTO.EmployeeDTO;
import com.tnd.businesschainsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account acc = accountRepository.findByUsername(username);

        if(acc == null || acc.getStatus()==0)
            throw new UsernameNotFoundException("Not found user with username = "+username);

        List<EmployeeRole> employeeRoles = employeeRoleRepository.findByEmployeeId(acc.getEmployee());
        List<GrantedAuthority> list = new ArrayList<>();
        for(EmployeeRole employeeRole : employeeRoles) {
            Optional<Role> role = roleRepository.findById(employeeRole.getRole());
            list.add(new SimpleGrantedAuthority("ROLE_" + role.get().getRole()));
        }

        User principal = new User(username, acc.getPassword(), true, true, true, true, list);

        return principal;
    }

    public EmployeeDTO getCurrentUserID(String username) {

        Account acc = accountRepository.findByUsername(username);
        Employee employee = employeeRepository.findById(acc.getEmployee()).get();
        Branch branch = branchRepository.findById(employee.getBranch()).get();
        Role role = null;
        List<EmployeeRole> employeeRoles = employeeRoleRepository.findByEmployeeId(employee.getId());
        if(employeeRoles.size()>0){
            role = roleRepository.findById(employeeRoles.get(0).getRole()).get();
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.doMappingEmployee(employee, role, branch);

        return employeeDTO;
    }
}
