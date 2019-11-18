package com.tnd.businesschainsystem.Controller;

import com.tnd.businesschainsystem.Model.Payroll;
import com.tnd.businesschainsystem.Model.Spend;
import com.tnd.businesschainsystem.Service.BudgetManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetManagementController {

    @Autowired
    private BudgetManagementService budgetManagementService;

    @PostMapping("/spend")
    public ResponseEntity<?> addSpend(@RequestBody Spend spend) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(budgetManagementService.addSpend(spend, auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/payroll")
    public ResponseEntity<?> getPayrolls(@RequestParam(defaultValue = "10",required = false) int month,
                                         @RequestParam(defaultValue = "2019",required = false) int year,
                                         @RequestParam(defaultValue = "null",required = false)String branch,
                                         @RequestParam(defaultValue = "null",required = false)String role) {

        return new ResponseEntity<>(budgetManagementService.getPayrolls(month,year,branch,role),HttpStatus.OK);
    }

    @PostMapping("/payroll")
    public ResponseEntity<?> addPayrolls(@RequestBody List<Payroll> payrolls) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(budgetManagementService.addPayrolls(payrolls,auth.getName()),HttpStatus.OK);
    }

    @GetMapping("/report/sales")
    public ResponseEntity<?> getSales(@RequestParam(defaultValue = "01/11/2019") String fromDate,
                                      @RequestParam(defaultValue = "31/11/2019") String toDate,
                                      @RequestParam(defaultValue = "null",required = false) String branch) {

        return new ResponseEntity<>(budgetManagementService.getReportSales(fromDate,toDate,branch),HttpStatus.OK);
    }

    @GetMapping("/report/teaching")
    public ResponseEntity<?> getReportTeaching(@RequestParam(defaultValue = "01/11/2019") String fromDate,
                                      @RequestParam(defaultValue = "31/11/2019") String toDate,
                                      @RequestParam(defaultValue = "null",required = false) String branch) {

        return new ResponseEntity<>(budgetManagementService.getReportTeaching(fromDate,toDate,branch),HttpStatus.OK);
    }

    @GetMapping("/report/salary")
    public ResponseEntity<?> getReportSalary(@RequestParam(defaultValue = "8") int fromMonth,
                                             @RequestParam(defaultValue = "2019") int fromYear,
                                             @RequestParam(defaultValue = "12") int toMonth,
                                             @RequestParam(defaultValue = "2019") int toYear,
                                             @RequestParam(defaultValue = "null",required = false) String branch) {

        return new ResponseEntity<>(budgetManagementService.getReportSalary(fromMonth,fromYear,toMonth, toYear, branch),HttpStatus.OK);
    }

    @GetMapping("/report/profit")
    public ResponseEntity<?> getReportProfit(@RequestParam(defaultValue = "8") int fromMonth,
                                             @RequestParam(defaultValue = "2019") int fromYear,
                                             @RequestParam(defaultValue = "12") int toMonth,
                                             @RequestParam(defaultValue = "2019") int toYear,
                                             @RequestParam(defaultValue = "null",required = false) String branch) {

        return new ResponseEntity<>(budgetManagementService.getReportProfit(fromMonth,fromYear,toMonth, toYear, branch),HttpStatus.OK);
    }
}
