package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Model.DTO.BranchDTO;
import com.tnd.businesschainsystem.Model.DTO.ItemMenuDAO;
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

        List<Rule> listItems = ruleRepository.findByBranchIdAndType(branchId,Rule.MENU_ITEM);
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
            List<Rule> rules = ruleRepository.findByBranchId(branches.get(i).getId());
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.doMappingBranch(branches.get(i), employee, rules);
            list.add(branchDTO);
        }
        return list;
    }

    @Override
    public BranchDTO getBranch(int branchId) {

            Branch branch = branchRepository.findById(branchId).get();
            List<Rule> rules = ruleRepository.findByBranchId(branch.getId());
            Employee employee = employeeRepository.findById(branch.getManager()).get();
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.doMappingBranch(branch, employee, rules);
            return branchDTO;
    }

    @Override
    public ResponseDTO addBranch(BranchDTO branchDTO) {

        try {

            Branch branch = new Branch();
            branch.doMappingBranchDTO(branchDTO);
            branchRepository.save(branch);

            branchDTO.getRules().stream().forEach(rule -> {
                rule.generateId();
                rule.setBranch(branch.getId());
            });
            ruleRepository.saveAll(branchDTO.getRules());
            return new ResponseDTO().success(Constants.DONE_ADDBRANCH);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDBRANCH);
        }
    }

    @Override
    public ResponseDTO updateBranch(BranchDTO branchDTO, int branchId) {

        try {

            Branch branch = branchRepository.findById(branchId).get();
            branch.doMappingBranchDTO(branchDTO);
            branchRepository.save(branch);

            List<Rule> oldRules = ruleRepository.findByBranchId(branchId);
            for(int i=0;i<oldRules.size();i++)
                for(int j=0;j<branchDTO.getRules().size();j++) {
                    if(oldRules.get(i).getId() == branchDTO.getRules().get(j).getId()){
                        ruleRepository.save(branchDTO.getRules().get(j));
                        oldRules.remove(i);
                        branchDTO.getRules().remove(j);
                        i--;
                        break;
                    }
                }
            ruleRepository.deleteAll(oldRules);
            ruleRepository.saveAll(branchDTO.getRules());

            return new ResponseDTO().success(Constants.DONE_UPDATEBRANCH);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_UPDATEBRANCH);
        }
    }
}
