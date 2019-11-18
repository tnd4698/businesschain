package com.tnd.businesschainsystem.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeworkList {

    private Date date;
    private int branchId;
    private String branchName;

    public String getDate() {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(this.date);
    }

    public void setDate(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            this.date = df.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
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
}
