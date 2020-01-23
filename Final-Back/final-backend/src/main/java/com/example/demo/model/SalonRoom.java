package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name ="SALONROOMS")
public class SalonRoom {

    @Id
    @Column(name ="ID", nullable = false,  unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="NAME", nullable = false )
    private String name;

    @Column(name= "CAPACITY", nullable = false)
    private Integer capacity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PLACE")
    private Place places;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Place getPlaces() {
        return places;
    }

    public void setPlaces(Place places) {
        this.places = places;
    }
    /*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
