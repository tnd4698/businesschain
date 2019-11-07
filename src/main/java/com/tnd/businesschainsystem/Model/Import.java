package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="import")
public class Import {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="resourceID")
    private String resourceID;

    @Column(name="count")
    private int count;

    @Column(name="price")
    private long price;

    @Column(name="totalMoney")
    private long totalMoney;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="createdBy")
    private int createdBy;
}
