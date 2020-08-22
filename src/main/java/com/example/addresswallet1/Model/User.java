package com.example.addresswallet1.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {
    private final UUID userID;
    @NotBlank
    private String username;
    private String forename;
    private String surname;

    public User(@JsonProperty("userid") UUID userID, @JsonProperty("username") String username) {
        this.userID = userID;
        this.username = username;
        System.out.println("in user object constructor");
    }

    public User(UUID userID) {
        this.userID = userID;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User u = (User) obj;
            if (u.getUserID().equals(this.userID)) {
                return true;
            }
        }
        return false;
    }
}
