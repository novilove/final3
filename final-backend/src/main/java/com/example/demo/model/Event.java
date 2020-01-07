package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="EVENTS")
public class Event {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TIME")
    private String time;

    @Column(name = "DATE")
    private String date;

    @Column(name = "CAPACITY")
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "FK_PLACES", nullable = false, updatable = false)
    private Place place;

    @OneToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category fkCategory;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Talk> talkList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<UserEvent> userEventList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Category getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(Category fkCategory) {
        this.fkCategory = fkCategory;
    }



    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<UserEvent> getUserEventList() {
        return userEventList;
    }

    public void setUserEventList(List<UserEvent> userEventList) {
        this.userEventList = userEventList;
    }
}

