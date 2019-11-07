package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.TuitionDTO;
import com.tnd.businesschainsystem.Service.TuitionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tuition")
public class TuitionManagementController {

    @Autowired
    private TuitionManagementService tuitionManagementService;

    @PostMapping
    private ResponseEntity<?> add(@RequestBody TuitionDTO tuitionDTO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(tuitionManagementService.add(tuitionDTO,auth.getName()), HttpStatus.OK);
    }
}
