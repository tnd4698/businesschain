package com.tnd.businesschainsystem.Model;

import java.util.Date;

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

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public void doMappingBranch(Branch branch, Employee employee) {
        this.id = branch.getId();
        this.name = branch.getName();
        this.address = branch.getAddress();
        this.managerId = branch.getManager();
        this.managerID = employee.getEmployeeID();
        this.managerName = employee.getName();
        this.managerPhone = employee.getPhoneNumber();
        this.status = branch.getStatus();
        this.openDate = branch.getOpenDate();
    }
}
