package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Model.BranchDTO;
import com.tnd.businesschainsystem.Model.ItemMenuDAO;

import java.util.List;

public interface BranchManagementService {

    List<ItemMenuDAO> getMenuItems(int branchId);

    List<BranchDTO> getBranches(String status);
}
