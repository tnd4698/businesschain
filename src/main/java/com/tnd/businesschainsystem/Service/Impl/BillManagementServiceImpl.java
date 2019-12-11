package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.Account;
import com.tnd.businesschainsystem.Model.Bill;
import com.tnd.businesschainsystem.Model.Branch;
import com.tnd.businesschainsystem.Model.Employee;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.BillManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillManagementServiceImpl implements BillManagementService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseDTO add(List<Bill> listBill, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            Employee employee = employeeRepository.findById(acc.getEmployee()).get();
            Branch branch = branchRepository.findById(employee.getBranch()).get();
            for (Bill item : listBill) {

                Bill bill = new Bill();
                bill.setItemMenu(item.getItemMenu());
                bill.setBranch(branch.getId());
                bill.setCount(item.getCount());
                bill.setPrice(item.getPrice());
                bill.setTotal(item.getCount()*item.getPrice());
                bill.setCreatedBy(acc.getEmployee());
                bill.setCreateDate(new Date());
                billRepository.save(bill);
            }
            return new ResponseDTO().success(Constants.DONE_ADDBILL);
        }
        catch(Exception e) {
            return new ResponseDTO().success(Constants.FAIL_ADDBILL);
        }
    }
}
