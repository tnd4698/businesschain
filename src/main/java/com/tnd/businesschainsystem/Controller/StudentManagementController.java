package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.DTO.StudentDTO;
import com.tnd.businesschainsystem.Service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentManagementController {

    @Autowired
    private StudentManagementService studentManagementService;

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam(defaultValue = "null", required = false) String branch,
                                         @RequestParam(defaultValue = "null", required = false) String tuition,
                                         @RequestParam(defaultValue = "1", required = false) String status) {

        return new ResponseEntity<>(studentManagementService.getStudents(branch, tuition, status), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(studentManagementService.add(auth.getName(),studentDTO),HttpStatus.OK);
    }

    @PutMapping("/{studentID}")
    public ResponseEntity<?> updateStudent(@PathVariable String studentID, @RequestBody StudentDTO studentDTO) {

        return new ResponseEntity<>(studentManagementService.update(studentID, studentDTO),HttpStatus.OK);
    }
}
