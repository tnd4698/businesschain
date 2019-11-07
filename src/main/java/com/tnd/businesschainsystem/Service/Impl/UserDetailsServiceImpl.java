package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Model.Account;
import com.tnd.businesschainsystem.Model.EmployeeRole;
import com.tnd.businesschainsystem.Model.Role;
import com.tnd.businesschainsystem.Repository.AccountRepository;
import com.tnd.businesschainsystem.Repository.EmployeeRoleRepository;
import com.tnd.businesschainsystem.Repository.RoleRepository;
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
}
