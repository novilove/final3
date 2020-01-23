package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="COUNTRY")
public class Country {
    @Id
    @Column(name="ID",nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="NAME",nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
Giovanna Tapia
giovannatss27@gmail.com
 */

}
