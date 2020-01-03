package com.tnd.businesschainsystem.Model;

import com.tnd.businesschainsystem.Model.DTO.StudentDTO;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="studentID")
    private String studentID;

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

    public int getId() {
        return id;
    }

    public String getStudentID() {
        return studentID;
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

    public void generateID(int stt){
        String rs = "STUDENT";
        String temp = String.valueOf(stt);
        while(temp.length()<6)
            temp = "0" + temp;
        rs+=temp;
        this.studentID = rs;
    }

    public void doMappingStudentDTO(StudentDTO studentDTO) {

        this.name = studentDTO.getName();
        this.cardID = studentDTO.getCardID();
        this.birthDay = studentDTO.getBirthDay();
        this.gender = studentDTO.getGender();
        this.address = studentDTO.getAddress();
        this.phoneNumber = studentDTO.getPhoneNumber();
        this.email = studentDTO.getEmail();
        this.branch = studentDTO.getBranchId();
    }
}
