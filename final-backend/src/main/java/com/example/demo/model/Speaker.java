package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name="SPEAKER")
public class Speaker {

    @Id
    @Column(name="ID",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DESCRIPTION", nullable = false)
    private String description;

    @Column(name="CHARGE", nullable = false)
    private String charge;

    @ManyToOne
    @JoinColumn(name = "FK_COUNTRY", nullable = false)
    private Country country;

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

    public String getChange() {
        return charge;
    }

    public void setChange(String change) {
        this.charge = change;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
