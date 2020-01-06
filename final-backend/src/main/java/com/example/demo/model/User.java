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

    @Column(name ="AGE", nullable = false)
    private Integer age;

    @OneToOne
    @JoinColumn(name = "FK_LOGIN", nullable = false)
    private Login logins;

    private String  type;
    private String lastName;


}
