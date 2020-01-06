package com.example.demo.model;

import org.springframework.lang.UsesJava7;

import javax.persistence.*;

@Entity
@Table(name = "PLACES")
public class Place {

  @Id
  @Column(name = "ID",nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="CITY", nullable = false)
  private String city;

  @Column(name="ADDRES", nullable = false)
  private String addres;

  @Column(name="NAME",nullable = false)
  private String name;

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

  public String getAddres() {
    return addres;
  }

  public void setAddres(String addres) {
    this.addres = addres;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
