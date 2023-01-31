package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;
    private String content;
    private Date date;

}
