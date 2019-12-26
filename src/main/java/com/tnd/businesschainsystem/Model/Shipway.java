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

    @Column(name = "price")
    private long price;

    @Column(name = "totalMoney")
    private long totalMoney;

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.createdDate);
    }

    public void setCreatedDate(String date) {

        try {
            this.createdDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
