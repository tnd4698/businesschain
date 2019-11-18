package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.Import;
import com.tnd.businesschainsystem.Model.ResourceDTO;
import com.tnd.businesschainsystem.Model.Shipway;
import com.tnd.businesschainsystem.Service.ResourceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<?> addResource(@RequestBody ResourceDTO resourceDTO) {

        return new ResponseEntity<>(resourceManagementService.addResource(resourceDTO),HttpStatus.OK);
    }

    @PutMapping("/{resourceID}")
    public ResponseEntity<?> updateResource(@PathVariable String resourceID, @RequestBody ResourceDTO resourceDTO) {

        return new ResponseEntity<>(resourceManagementService.updateResource(resourceID, resourceDTO),HttpStatus.OK);
    }

    @PostMapping("/shipway")
    public ResponseEntity<?> addShipways(@RequestBody List<Shipway> shipways) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(resourceManagementService.addShipways(shipways, auth.getName()),HttpStatus.OK);
    }

    @PostMapping("/import")
    public ResponseEntity<?> addImport(@RequestBody List<Import> imports) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(resourceManagementService.addImport(imports, auth.getName()),HttpStatus.OK);
    }
}
