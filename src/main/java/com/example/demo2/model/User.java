package com.example.demo2.model;

import com.example.demo2.utils.MD5Util;


public class User {
    private Integer id;

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = MD5Util.string2MD5(password);
        this.email = email;
    }

    private String username;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = MD5Util.string2MD5(password);
        this.email = email;
    }

    public User(){}

    private String password;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MD5Util.string2MD5(password);;
    }

}
