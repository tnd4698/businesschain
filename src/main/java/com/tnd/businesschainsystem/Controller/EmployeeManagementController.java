package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.EmployeeDTO;
import com.tnd.businesschainsystem.Model.Timework;
import com.tnd.businesschainsystem.Model.TimeworkDTO;
import com.tnd.businesschainsystem.Service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService employeeManagementService;

    @GetMapping
    public ResponseEntity<?> getEmployees(@RequestParam(value="branch",defaultValue = "null",required = false) String branch,
                                          @RequestParam(value="role",defaultValue = "null",required = false) String role,
                                          @RequestParam(value="status",defaultValue = "1",required = false) String status) {

        List<EmployeeDTO> list = employeeManagementService.getEmployees(branch, role, status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<?> getEmployee(@PathVariable String employeeID) {

        return new ResponseEntity<>(employeeManagementService.getEmployee(employeeID),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employee) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(employeeManagementService.add(employee,auth.getName()),HttpStatus.OK);
    }

    @PutMapping("/{employeeID}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employee, @PathVariable String employeeID) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(employeeManagementService.update(employee,employeeID, auth.getName()),HttpStatus.OK);
    }

    @GetMapping("/timeworks")
    public ResponseEntity<?> getTimeworks(@RequestParam String startDate,
                                          @RequestParam String endDate,
                                          @RequestParam(value="branch",defaultValue = "null",required = false) String branch) {

        return new ResponseEntity<>(employeeManagementService.getTimeworks(startDate, endDate, branch),HttpStatus.OK);
    }

    @GetMapping("/timeworks/new")
    public ResponseEntity<?> getNewTimeworks(@RequestParam String date, @RequestParam int branchId) {

        return new ResponseEntity<>(employeeManagementService.getNewTimeworks(date, branchId),HttpStatus.OK);
    }

    @PostMapping("/timeworks")
    public ResponseEntity<?> addTimeworks(@RequestBody List<TimeworkDTO> timeworkDTOs) {

        return new ResponseEntity<>(employeeManagementService.addTimeworks(timeworkDTOs),HttpStatus.OK);
    }

    @PutMapping("/timeworks")
    public ResponseEntity<?> updateTimeworks(@RequestBody List<Timework> timeworks) {

        return new ResponseEntity<>(employeeManagementService.updateTimeworks(timeworks),HttpStatus.OK);
    }

}
