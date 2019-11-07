package com.tnd.businesschainsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="material_branch")
public class MaterialBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="material")
    private int material;

    @Column(name="branch")
    private int branch;

    @Column(name="count")
    private int count;

    public int getId() {
        return id;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
