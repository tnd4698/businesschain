package com.tnd.businesschainsystem.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatisticsDTO {

    private Date fromDate;
    private Date toDate;
    private int branchId;
    private String branchName;
    private long value;

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

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
