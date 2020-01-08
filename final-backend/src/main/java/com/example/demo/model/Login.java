package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="LOGINS")
public class Login {

    @Id
    @Column(name="EMAIL", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name= "PASSWORD", nullable = false)
    private String password;


    @OneToOne(mappedBy = "login",cascade = CascadeType.ALL)
    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }




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


}
