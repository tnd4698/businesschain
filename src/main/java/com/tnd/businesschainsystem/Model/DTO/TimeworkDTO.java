package com.tnd.businesschainsystem.Model.DTO;

import com.tnd.businesschainsystem.Model.Employee;
import com.tnd.businesschainsystem.Model.Timework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeworkDTO {

    public static final int ABSENT = 0;
    public static final int ACTIVE = 1;

    private int id;
    private Date date;
    private int employeeId;
    private String employeeID;
    private String employeeName;
    private int branchId;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.date);
    }

    public void setDate(String date) {

        try {
            this.date = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void doMappingTimework(Timework timework, Employee employee) {
        this.id = timework.getId();
        this.setDate(timework.getDate());
        this.employeeId=timework.getEmployee();
        this.employeeName=employee.getName();
        this.status=timework.getStatus();
        this.employeeID = employee.getEmployeeID();
        this.branchId=timework.getBranch();
    }
}
