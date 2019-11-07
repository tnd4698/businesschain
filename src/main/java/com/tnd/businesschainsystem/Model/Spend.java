package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
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
}
