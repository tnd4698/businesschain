package com.tnd.businesschainsystem.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeworkDTO {

    private int id;
    private Date date;
    private int employeeId;
    private String employeeName;
    private int status;

    public int getId() {
        return id;
    }

    public String getDate() {
        return (new SimpleDateFormat("dd/MM/yyyy")).format(this.date);
    }

    public void setDate(String date) {

        try {
            this.date = (new SimpleDateFormat("dd/MM/yyyy")).parse(date);
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
}
