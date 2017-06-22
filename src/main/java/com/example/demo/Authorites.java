package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by student on 6/22/17.
 */
@Entity
public class Authorites {
    @Id
    @NotNull
    private String username;
    private String authority = "ADMIN";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
