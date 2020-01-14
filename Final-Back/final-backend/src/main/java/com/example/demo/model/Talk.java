package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name= "TALK")
public class Talk {

    @Id
    @Column(name ="ID", nullable = false,  unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "DESCRIPTION",nullable = false)
    private String description;

    @Column(name = "DURATION",nullable = false)
    private Integer duration;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_EVENT", nullable = false)
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_SPEAKER", nullable = false)
    private Speaker speakers;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_SALON_ROOM", nullable = false)
    private SalonRoom  salon;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Speaker getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speaker speakers) {
        this.speakers = speakers;
    }

    public SalonRoom getSalon() {
        return salon;
    }

    public void setSalon(SalonRoom salon) {
        this.salon = salon;
    }
}
