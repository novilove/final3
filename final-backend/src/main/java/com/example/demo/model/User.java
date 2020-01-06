package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="LAST_NAME",nullable = false)
    private String lastName;

    @Column(name ="AGE", nullable = false)
    private Integer age;

    @Column(name= "GENRE",nullable = false)
    private String genre;

    @Column(name="TYPE", nullable = false)
    private String  type;

    @OneToOne
    @JoinColumn(name = "FK_LOGIN", nullable = false)
    private Login logins;

    @ManyToOne
    @JoinColumn(name="FK_ID_COUNTRY")
    private Country countryUser;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Login getLogins() {
        return logins;
    }

    public void setLogins(Login logins) {
        this.logins = logins;
    }

    public Country getCountryUser() {
        return countryUser;
    }

    public void setCountryUser(Country countryUser) {
        this.countryUser = countryUser;
    }
}
