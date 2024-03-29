package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;

    @OneToMany(mappedBy = "role")
    private List<Users> users;

    public Integer getId() {
        return id;
    }

    public Role setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Role setLabel(String label) {
        this.label = label;
        return this;
    }

    public List<Users> getUsers() {
        return users;
    }

    public Role setUsers(List<Users> users) {
        this.users = users;
        return this;
    }
}
