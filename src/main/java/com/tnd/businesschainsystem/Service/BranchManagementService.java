package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.Branch;
import com.tnd.businesschainsystem.Model.BranchDTO;
import com.tnd.businesschainsystem.Model.ItemMenuDAO;

import java.util.List;

public interface BranchManagementService {

    List<ItemMenuDAO> getMenuItems(int branchId);

    List<BranchDTO> getBranches(String status);

    BranchDTO getBranch(int branchId);

    ResponseDTO addBranch(BranchDTO branchDTO);

    ResponseDTO updateBranch(BranchDTO branchDTO, int branchId);
}
