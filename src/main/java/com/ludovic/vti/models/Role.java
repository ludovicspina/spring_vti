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
    private List<User> users;

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
}
