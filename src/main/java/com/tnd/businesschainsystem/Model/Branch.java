package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="manager")
    private int manager;

    @Column(name="status")
    private int status;

    @Column(name="openDay")
    private Date openDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOpenDate() {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(this.openDate);
    }

    public void setOpenDate(String date) {

        try {
            this.openDate = (new SimpleDateFormat("yyyy/MM/dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public void doMappingBranchDTO(BranchDTO branchDTO) {
        this.name = branchDTO.getName();
        this.address = branchDTO.getAddress();
        this.manager = branchDTO.getManagerId();
        this.status = branchDTO.getStatus();
        this.setOpenDate(branchDTO.getOpenDate());
    }
}
