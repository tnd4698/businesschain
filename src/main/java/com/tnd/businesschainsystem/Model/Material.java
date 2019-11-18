package com.tnd.businesschainsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="materialID")
    private String materialID;

    @Column(name="name")
    private String name;

    @Column(name="count")
    private int count;

    public int getId() {
        return id;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
