package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="COUNTRY")
public class Country {
    @Id
    @Column(name="COUNTRY",nullable = false , unique = true)
    private long id;

    @Column(name="NAME",nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Place> placeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Speaker> speakerList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<User> userList;

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

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
