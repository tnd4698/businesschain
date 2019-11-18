package com.tnd.businesschainsystem.Model;

import java.util.Date;

public class EmployeeDTO {

    private int id;
    private String employeeID;
    private String name;
    private String cardID;
    private String birthDay;
    private int gender;
    private String address;
    private String phoneNumber;
    private String email;
    private int branchId;
    private String branchName;
    private int status;
    private long salary;
    private int roleId;
    private String roleName;
    private Date createdDate;
    private int createdBy;
    private Date updatedDate;
    private  int updatedBy;

    public int getId() {
        return id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void doMappingEmployee(Employee employee, Role role, Branch branch) {

        this.id = employee.getId();
        this.employeeID = employee.getEmployeeID();
        this.name = employee.getName();
        this.cardID = employee.getCardID();
        this.birthDay = employee.getBirthDay();
        this.gender = employee.getGender();
        this.address = employee.getAddress();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.branchId = employee.getBranch();
        this.branchName = branch.getName();
        this.status = employee.getStatus();
        this.salary = employee.getSalary();
        this.roleId = role.getId();
        this.roleName = role.getRole();
        this.createdDate = employee.getCreatedDate();
        this.createdBy = employee.getCreatedBy();
        this.updatedDate = employee.getUpdatedDate();
        this.updatedBy = employee.getUpdatedBy();
    }
}
