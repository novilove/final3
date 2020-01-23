package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "USEREVENTS")
public class UserEvent {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER", nullable = false)
    private User users;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_EVENT", nullable = false)
    private Event event;







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Event getEvents() {
        return event;
    }

    public void setEvents(Event events) {
        this.event = events;
    }
    /*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
