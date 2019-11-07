package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.ResourceDTO;
import com.tnd.businesschainsystem.Service.ResourceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class ResourceManagementController {

    @Autowired
    private ResourceManagementService resourceManagementService;

    @GetMapping
    public ResponseEntity<?> getResources(@RequestParam(defaultValue = "null",required = false) String branch,
                                          @RequestParam(defaultValue = "null",required = false) String type,
                                          @RequestParam(defaultValue = "1",required = false) String status) {

        return new ResponseEntity<>(resourceManagementService.getResources(branch,type,status), HttpStatus.OK);
    }

    @PutMapping("/{resourceID}")
    public ResponseEntity<?> updateResource(@PathVariable String resourceID, @RequestBody ResourceDTO resourceDTO) {

        return new ResponseEntity<>(resourceManagementService.updateResource(resourceID, resourceDTO),HttpStatus.OK);
    }
}
