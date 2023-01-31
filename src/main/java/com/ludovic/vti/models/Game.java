package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    private List<Post> post;

}
