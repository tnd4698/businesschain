package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="itemMenu")
    private int itemMenu;

    @Column(name="name")
    private String name;

    @Column(name= "count")
    private int count;

    @Column(name="price")
    private long price;

    @Column(name="total")
    private long total;

    @Column(name="createdDate")
    private Date createDate;

    @Column(name="createdBy")
    private int createdBy;

    public int getId() {
        return id;
    }

    public int getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(int itemMenu) {
        this.itemMenu = itemMenu;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
}
