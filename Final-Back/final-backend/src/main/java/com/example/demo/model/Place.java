package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="PLACES")
public class Place {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CITY",nullable = false)
    private String city;


    @Column(name = "ADRESS",nullable = false)
    private String adress;

    @Column(name = "NAME",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_COUNTRY", nullable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<SalonRoom> salonRoomList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Event> eventList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<SalonRoom> getSalonRoomList() {
        return salonRoomList;
    }

    public void setSalonRoomList(List<SalonRoom> salonRoomList) {
        this.salonRoomList = salonRoomList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
