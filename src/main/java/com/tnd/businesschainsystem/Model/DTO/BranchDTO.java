package com.tnd.businesschainsystem.Model.DTO;

import com.tnd.businesschainsystem.Model.Branch;
import com.tnd.businesschainsystem.Model.Employee;
import com.tnd.businesschainsystem.Model.Rule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BranchDTO {

    private int id;
    private String name;
    private String address;
    private int managerId;
    private String managerID;
    private String managerName;
    private String managerPhone;
    private int status;
    private Date openDate;
    private List<Rule> rules;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public String getOpenDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.openDate);
    }

    public void setOpenDate(String date) {

        try {
            this.openDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public void doMappingBranch(Branch branch, Employee employee, List<Rule> rules) {
        this.id = branch.getId();
        this.name = branch.getName();
        this.address = branch.getAddress();
        this.managerId = branch.getManager();
        this.managerID = employee.getEmployeeID();
        this.managerName = employee.getName();
        this.managerPhone = employee.getPhoneNumber();
        this.status = branch.getStatus();
        this.setOpenDate(branch.getOpenDate());
        this.rules = rules;
    }
}
