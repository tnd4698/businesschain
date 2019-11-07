package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.Bill;
import com.tnd.businesschainsystem.Service.BillManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillManagementController {

    @Autowired
    private BillManagementService billManagementService;

    @PostMapping
    public ResponseEntity<?> addBill(@RequestBody List<Bill> listBill) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return new ResponseEntity<>(billManagementService.add(listBill, auth.getName()), HttpStatus.OK);
    }
}
