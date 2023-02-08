package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String email;

    private String password;

    private Date registration_date;

    @ManyToOne
    private Role role;

    @ManyToMany
    private List<Game> games;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public Users setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
        return this;
    }

    public Role getRole() {
        return role;
    }

}