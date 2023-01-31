package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Date date;
    private String currency;
    private int price;

    @ManyToOne
    private Game game;

}
