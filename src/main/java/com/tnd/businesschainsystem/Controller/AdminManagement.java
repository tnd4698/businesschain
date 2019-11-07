package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Service.AdminManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminManagement {

    @Autowired
    private AdminManagementService adminManagementService;

    @GetMapping("/role")
    public ResponseEntity<?> getRoles() {

        return new ResponseEntity<>(adminManagementService.getRoles(), HttpStatus.OK);
    }
}
