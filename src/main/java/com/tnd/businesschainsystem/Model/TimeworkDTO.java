package com.tnd.businesschainsystem.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeworkDTO {

    public static final int ABSENT = 0;
    public static final int ACTIVE = 1;

    private int id;
    private Date date;
    private int employeeId;
    private String employeeName;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(this.date);
    }

    public void setDate(String date) {

        try {
            this.date = (new SimpleDateFormat("yyyy/MM/dd")).parse(date);
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

    public void doMappingTimework(Timework timework, Employee employee) {
        this.id = timework.getId();
        this.setDate(timework.getDate());
        this.employeeId=timework.getEmployee();
        this.employeeName=employee.getName();
        this.status=timework.getStatus();
    }
}
