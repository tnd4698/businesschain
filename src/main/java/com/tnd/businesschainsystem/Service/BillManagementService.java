package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.Bill;

import java.util.List;

public interface BillManagementService {

    ResponseDTO add(List<Bill> listBill, String username);
}
