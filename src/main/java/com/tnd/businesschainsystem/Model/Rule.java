package com.tnd.businesschainsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="rule")
public class Rule {

    public static final int MENU_ITEM = 0;
    public static final int CONTRACT = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private String value;

    @Column(name="branch")
    private int branch;

    @Column(name="type")
    private int type;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void generateId() {
        this.id = 0;
    }
}
