package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="shipway")
public class Shipway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="fromBranch")
    private int fromBranch;

    @Column(name="toBranch")
    private int toBranch;

    @Column(name = "resourceID")
    private String resourceID;

    @Column(name = "count")
    private int count;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "createdBy")
    private int createdBy;

    public int getId() {
        return id;
    }

    public void generateId() {
        this.id = 0;
    }

    public int getFromBranch() {
        return fromBranch;
    }

    public void setFromBranch(int fromBranch) {
        this.fromBranch = fromBranch;
    }

    public int getToBranch() {
        return toBranch;
    }

    public void setToBranch(int toBranch) {
        this.toBranch = toBranch;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
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
}
