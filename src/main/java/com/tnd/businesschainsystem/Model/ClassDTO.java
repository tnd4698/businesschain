package com.tnd.businesschainsystem.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClassDTO {

    private int id;
    private String classID;
    private int teacherId;
    private String teacherID;
    private String teacherName;
    private int status;
    private int branchId;
    private String branchName;
    private Date fromDate;
    private Date toDate;
    private List<Shift> shifts;
    private List<StudentDTO> students;

    public int getId() {
        return id;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
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

    public void doMappingClass(Classs classs, Branch branch, Employee teacher, List<StudentDTO> students, List<Shift> shifts) {

        this.id = classs.getId();
        this.classID = classs.getClassID();
        this.teacherId = teacher.getId();
        this.teacherID = teacher.getEmployeeID();
        this.teacherName = teacher.getName();
        this.status = classs.getStatus();
        this.branchId = classs.getBranch();
        this.branchName = branch.getName();
        this.setFromDate(classs.getFromDate());
        this.setToDate(classs.getToDate());
        this.students = students;
        this.shifts = shifts;
    }
}
