package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="spend")
public class Spend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="totalMoney")
    private long totalMoney;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="createdBy")
    private int createdBy;

    @Column(name="branch")
    private int branch;

    public int getId() {
        return id;
    }

    public void generateId() {
        this.id = 0;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
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

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }
}
