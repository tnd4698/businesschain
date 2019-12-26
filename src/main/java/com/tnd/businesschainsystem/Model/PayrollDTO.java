package com.tnd.businesschainsystem.Model;

import javax.persistence.Column;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayrollDTO {

    private int id;
    private int month;
    private int year;
    private int employee;
    private long salary;
    private int absent;
    private long other;
    private String contentOther;
    private int totalMoney;
    private Date createdDate;
    private int createdBy;
    private String employeeID;
    private String employeeName;
    private int branchId;

    public int getId() {
        return id;
    }

    public void generateId() {
        this.id = 0;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public long getOther() {
        return other;
    }

    public void setOther(long other) {
        this.other = other;
    }

    public String getContentOther() {
        return contentOther;
    }

    public void setContentOther(String contentOther) {
        this.contentOther = contentOther;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getCreatedDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.createdDate);
    }

    public void setCreatedDate(String date) {

        try {
            this.createdDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
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

    public void doMappingPayroll(Payroll payroll, Employee employee) {
        this.id = payroll.getId();
        this.month = payroll.getMonth();
        this.year=payroll.getYear();
        this.employee=payroll.getEmployee();
        this.salary=payroll.getSalary();
        this.absent = payroll.getAbsent();
        this.other=payroll.getOther();
        this.contentOther=payroll.getContentOther();
        this.totalMoney=payroll.getTotalMoney();
        this.setCreatedDate(payroll.getCreatedDate());
        this.createdBy=payroll.getCreatedBy();
        this.employeeID = employee.getEmployeeID();
        this.employeeName = employee.getName();
        this.branchId = employee.getBranch();
    }
}
