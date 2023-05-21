package com.ludovic.vti.models;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Date registration_date;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "buyer")
    private List<Post> buyerPosts;

    public void setId(Long id) {
        this.id = id;
    }

    public List<Post> getBuyerPosts() {
        return buyerPosts;
    }

    public void setBuyerPosts(List<Post> buyerPosts) {
        this.buyerPosts = buyerPosts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return Math.toIntExact(id);
    }

    public void setId(Integer id) {
        this.id = Long.valueOf(id);
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

    public void setRole(Role role) {
        this.role = role;
    }
}