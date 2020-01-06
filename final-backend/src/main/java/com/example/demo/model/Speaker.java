package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name="SPEAKER")
public class Speaker {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="NAME", nullable = false)
    private String name;
    @Column(name="DESCRIPTION", nullable = false)
    private String Description;
    @Column(name="COUNTRY", nullable = false)
    private String Country;
    @Column(name="CHANGE", nullable = false)
    private String Change;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getChange() {
        return Change;
    }

    public void setChange(String change) {
        Change = change;
    }
}
