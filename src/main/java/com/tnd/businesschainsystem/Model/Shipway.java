package com.tnd.businesschainsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="shipway")
public class Shipway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="fromBranch")
    private int fromBranch;

    @Column(name="toBranch")
    private int toBranch;

    @Column(name = "resourceID")
    private String resourceID;

    @Column(name = "count")
    private int count;
}
