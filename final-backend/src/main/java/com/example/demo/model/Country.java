package com.example.demo.model;

import javax.persistence.*;
@Entity
@Table (name="COUNTRY")
public class Country {
@Id
@Column(name="COUNTRY",nullable = false , unique = true)
private long Id;

@Column(name="NAME",nullable = false)
private String name;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
