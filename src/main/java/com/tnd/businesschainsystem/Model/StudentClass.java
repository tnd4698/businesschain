package com.tnd.businesschainsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="student_class")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="student")
    private int student;

    @Column(name="class")
    private int classs;

    @Column(name="status")
    private int status;

    @Column(name="statusTuition")
    private int statusTuition;

    public int getId() {
        return id;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getClasss() {
        return classs;
    }

    public void setClasss(int classs) {
        this.classs = classs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatusTuition() {
        return statusTuition;
    }

    public void setStatusTuition(int statusTuition) {
        this.statusTuition = statusTuition;
    }
}
