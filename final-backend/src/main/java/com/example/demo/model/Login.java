package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="LOGINS")
public class Login {
    @Id
    @Column(name="EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name= "PASSWORD", nullable = false)
    private String password;

    @OneToOne(mappedBy = "logins",cascade = CascadeType.ALL)
    private User users;


    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}