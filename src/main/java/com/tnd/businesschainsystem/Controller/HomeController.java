package com.tnd.businesschainsystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> index() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(auth.getAuthorities().toString().equals("[ROLE_ANONYMOUS]")?false:true,HttpStatus.OK);
    }

    @GetMapping("/api/auth/role")
    public ResponseEntity<?> role(){

        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toString(), HttpStatus.OK);
    }

}
