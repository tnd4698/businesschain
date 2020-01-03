package com.tnd.businesschainsystem.Model.DTO;


import com.tnd.businesschainsystem.Model.Branch;
import com.tnd.businesschainsystem.Model.Classs;
import com.tnd.businesschainsystem.Model.Student;
import com.tnd.businesschainsystem.Model.StudentClass;

public class StudentDTO {

    private int id;
    private String studentID;
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
    private int classId;
    private String classID;
    private int statusTuition;

    public int getId() {
        return id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public int getStatusTuition() {
        return statusTuition;
    }

    public void setStatusTuition(int statusTuition) {
        this.statusTuition = statusTuition;
    }

    public void doMappingStudent(Student student, StudentClass studentClass, Classs classs, Branch branch) {
        this.id = student.getId();
        this.studentID = student.getStudentID();
        this.name = student.getName();
        this.cardID = student.getCardID();
        this.birthDay = student.getBirthDay();
        this.gender = student.getGender();
        this.address = student.getAddress();
        this.phoneNumber = student.getPhoneNumber();
        this.email = student.getEmail();
        this.branchId = student.getBranch();
        this.branchName = branch.getName();
        this.status = student.getStatus();
        if(studentClass != null && classs != null) {
            this.classId = studentClass.getClasss();
            this.statusTuition = studentClass.getStatusTuition();
            this.classID = classs.getClassID();
        }
        else {
            this.classId = -1;
            this.statusTuition = 0;
            this.classID = "null";
        }
    }
}
