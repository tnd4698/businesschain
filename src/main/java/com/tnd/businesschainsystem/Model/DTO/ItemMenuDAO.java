package com.tnd.businesschainsystem.Model.DTO;

import com.tnd.businesschainsystem.Model.Rule;

public class ItemMenuDAO {

    private int id;
    private String name;
    private long price;
    private int branch;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public void doMappingRule(Rule rule) {
        this.id=rule.getId();
        this.name=rule.getName();
        this.branch=rule.getBranch();
        this.price = Long.parseLong(rule.getValue());
    }
}
