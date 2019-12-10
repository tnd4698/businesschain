package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Service.EmployeeManagementService;
import com.tnd.businesschainsystem.Service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public ResponseEntity<?> index() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(auth.getAuthorities().toString().equals("[ROLE_ANONYMOUS]")?false:true,HttpStatus.OK);
    }

    @GetMapping("/api/auth/role")
    public ResponseEntity<?> getRole(){

        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toString(), HttpStatus.OK);
    }

    @GetMapping("/api/auth/user")
    public ResponseEntity<?> getUser(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(userDetailsService.getCurrentUserID(auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
