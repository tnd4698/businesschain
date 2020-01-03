package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.DTO.ClassDTO;
import com.tnd.businesschainsystem.Service.ClassManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
public class ClassManagementController {

    @Autowired
    private ClassManagementService classManagementService;

    @GetMapping
    public ResponseEntity<?> getClasses(@RequestParam(defaultValue = "null", required = false) String branch,
                                        @RequestParam(defaultValue = "1",required = false) String status) {
        return new ResponseEntity<>(classManagementService.getClasses(branch,status), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addClass(@RequestBody ClassDTO classDTO) {

        return new ResponseEntity<>(classManagementService.addClass(classDTO),HttpStatus.OK);
    }

    @PutMapping("/{classID}")
    public ResponseEntity<?> updateClass(@PathVariable String classID, @RequestBody ClassDTO classDTO) {

        return new ResponseEntity<>(classManagementService.updateClass(classID, classDTO),HttpStatus.OK);
    }

    @GetMapping("/shifts")
    private ResponseEntity<?> getShifts() {

        return new ResponseEntity<>(classManagementService.getShifts(),HttpStatus.OK);
    }
}
