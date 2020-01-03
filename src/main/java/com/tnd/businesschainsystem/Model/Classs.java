package com.tnd.businesschainsystem.Model;

import com.tnd.businesschainsystem.Model.DTO.ClassDTO;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="class")
public class Classs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="classID")
    private String classID;

    @Column(name="teacher")
    private int teacher;

    @Column(name="status")
    private int status;

    @Column(name="branch")
    private int branch;

    @Column(name="fromDate")
    private Date fromDate;

    @Column(name="toDate")
    private Date toDate;

    public int getId() {
        return id;
    }

    public String getClassID() {
        return classID;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public String getFromDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.fromDate);
    }

    public void setFromDate(String date) {

        try {
            this.fromDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public String getToDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.toDate);
    }

    public void setToDate(String date) {

        try {
            this.toDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public void generateID(int stt) {
        String rs = "CLASS";
        String temp = String.valueOf(stt);
        while(temp.length()<6)
            temp = "0" + temp;
        rs+=temp;
        this.classID = rs;
    }

    public void doMappingClassDTO(ClassDTO classDTO) {
        this.teacher = classDTO.getTeacherId();
        this.status = classDTO.getStatus();
        this.branch = classDTO.getBranchId();
        this.setFromDate(classDTO.getFromDate());
        this.setToDate(classDTO.getToDate());
    }
}
