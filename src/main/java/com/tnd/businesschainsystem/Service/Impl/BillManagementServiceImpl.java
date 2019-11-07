package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.Account;
import com.tnd.businesschainsystem.Model.Bill;
import com.tnd.businesschainsystem.Model.Rule;
import com.tnd.businesschainsystem.Repository.AccountRepository;
import com.tnd.businesschainsystem.Repository.BillRepository;
import com.tnd.businesschainsystem.Repository.RuleRepository;
import com.tnd.businesschainsystem.Service.BillManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillManagementServiceImpl implements BillManagementService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ResponseDTO add(List<Bill> listBill, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            for (Bill item : listBill) {

                Bill bill = new Bill();
                bill.setItemMenu(item.getId());
                bill.setName(item.getName());
                bill.setCount(item.getCount());
                bill.setPrice(item.getPrice());
                bill.setTotal(item.getCount()*item.getPrice());
                bill.setCreatedBy(acc.getEmployee());
                billRepository.save(bill);
            }
            return new ResponseDTO().success(Constants.DONE_ADDBILL);
        }
        catch(Exception e) {
            return new ResponseDTO().success(Constants.FAIL_ADDBILL);
        }
    }
}
