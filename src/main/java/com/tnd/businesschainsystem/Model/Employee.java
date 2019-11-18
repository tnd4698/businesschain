package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="employeeID")
    private String employeeID;

    @Column(name="name")
    private String name;

    @Column(name="cardID")
    private String cardID;

    @Column(name="birthDay")
    private String birthDay;

    @Column(name="gender")
    private int gender;

    @Column(name="address")
    private String address;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="branch")
    private int branch;

    @Column(name="status")
    private int status;

    @Column(name="salary")
    private long salary;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="createdBy")
    private int createdBy;

    @Column(name="updatedDate")
    private Date updatedDate;

    @Column(name="updatedBy")
    private  int updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeID() {
        return employeeID;
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

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
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

    public void generateID(int stt){
        String rs = "EMPLOYEE";
        String temp = String.valueOf(stt);
        while(temp.length()<6)
            temp = "0" + temp;
        rs+=temp;

        this.employeeID = rs;
    }

    public void doMappingEmployeeDTO(EmployeeDTO e) {

        this.name = e.getName();
        this.cardID = e.getCardID();
        this.birthDay = e.getBirthDay();
        this.gender = e.getGender();
        this.address = e.getAddress();
        this.phoneNumber = e.getPhoneNumber();
        this.email = e.getEmail();
        this.branch = e.getBranchId();
        this.status = e.getStatus();
        this.salary = e.getSalary();
        this.createdDate = e.getCreatedDate();
        this.createdBy = e.getCreatedBy();
        this.updatedDate = e.getUpdatedDate();
        this.updatedBy = e.getUpdatedBy();
    }
}
