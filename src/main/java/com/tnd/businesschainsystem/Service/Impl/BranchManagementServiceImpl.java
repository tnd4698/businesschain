package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.BranchRepository;
import com.tnd.businesschainsystem.Repository.EmployeeRepository;
import com.tnd.businesschainsystem.Repository.RuleRepository;
import com.tnd.businesschainsystem.Service.BranchManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchManagementServiceImpl implements BranchManagementService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<ItemMenuDAO> getMenuItems(int branchId) {

        List<Rule> listItems = ruleRepository.findByBranchIdAndType(branchId,0);
        List<ItemMenuDAO> list = new ArrayList<>();
        for(Rule rule : listItems) {
            ItemMenuDAO itemMenuDAO = new ItemMenuDAO();
            itemMenuDAO.doMappingRule(rule);
            list.add(itemMenuDAO);
        }
        return list;
    }

    @Override
    public List<BranchDTO> getBranches(String status) {

        List<BranchDTO> list = new ArrayList<>();

        List<Branch> branches = (List<Branch>) branchRepository.findAll();
        for(int i=0;i<branches.size();i++) {

            if(!status.equals("null"))
                if(branches.get(i).getStatus()!= Integer.parseInt(status))
                    continue;

            Employee employee = employeeRepository.findById(branches.get(i).getManager()).get();

            BranchDTO branchDTO = new BranchDTO();
            branchDTO.doMappingBranch(branches.get(i), employee);
            list.add(branchDTO);
        }
        return list;
    }
}
