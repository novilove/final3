package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "FK_PLACES")
    private Place fkPlace;

    @Column(name = "FK_CATEGORY")
    private Category fkCategory;

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

    public Place getFkPlace() {
        return fkPlace;
    }

    public void setFkPlace(Place fkPlace) {
        this.fkPlace = fkPlace;
    }

    public Category getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(Category fkCategory) {
        this.fkCategory = fkCategory;
    }
}

