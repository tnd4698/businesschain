package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.DTO.BranchDTO;
import com.tnd.businesschainsystem.Model.DTO.ItemMenuDAO;
import com.tnd.businesschainsystem.Service.BranchManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchManagementController {

    @Autowired
    private BranchManagementService branchManagementService;

    @GetMapping("/{branchId}/menu-items")
    public ResponseEntity<?> menuItem(@PathVariable int branchId) {

        List<ItemMenuDAO> list = branchManagementService.getMenuItems(branchId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getBranches(@RequestParam(value="status",defaultValue = "1",required = false) String status) {

        List<BranchDTO> list = branchManagementService.getBranches(status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<?> getBranch(@PathVariable int branchId) {

        return new ResponseEntity<>(branchManagementService.getBranch(branchId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBranch(@RequestBody BranchDTO branchDTO) {

        return new ResponseEntity<>(branchManagementService.addBranch(branchDTO),HttpStatus.OK);
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<?> updateBranch(@RequestBody BranchDTO branchDTO, @PathVariable int branchId) {

        return new ResponseEntity<>(branchManagementService.updateBranch(branchDTO,branchId),HttpStatus.OK);
    }
}
