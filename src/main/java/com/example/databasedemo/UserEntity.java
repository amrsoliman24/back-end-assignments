package com.example.databasedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class UserEntity {
    @Id
    @Column(nullable = false , name = "user_id")
    long id ;

    @Column(nullable = false , name = "usernameee" )
    private String username;
    private String Email ;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return Email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
