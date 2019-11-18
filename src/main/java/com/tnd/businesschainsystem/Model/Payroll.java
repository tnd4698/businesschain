package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="month")
    private int month;

    @Column(name="year")
    private int year;

    @Column(name="employee")
    private int employee;

    @Column(name="salary")
    private long salary;

    @Column(name="absent")
    private int absent;

    @Column(name="other")
    private long other;

    @Column(name="contentOther")
    private String contentOther;

    @Column(name="totalMoney")
    private int totalMoney;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="createdBy")
    private int createdBy;

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

    public String getCreatedDate() {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(this.createdDate);
    }

    public void setCreatedDate(String date) {

        try {
            this.createdDate = (new SimpleDateFormat("yyyy/MM/dd")).parse(date);
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
}
