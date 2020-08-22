package com.example.addresswallet1.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class Users {
    private String username;
    private String password;
    private String forename;
    private String surname;
    private Integer userID;

    public Users(@JsonProperty("username") String username, @JsonProperty("forename") String forename, @JsonProperty("surname") String surname) {
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        userID = null;
    }

  /*  public Users(@JsonProperty("userid") int userID, @JsonProperty("username") String username, @JsonProperty("forename") String forename, @JsonProperty("surname") String surname) {
        this.userID = userID;
        this.username = username;
        this.forename = forename;
        this.surname = surname;
    }

    public Users(Integer userID, String username, String password, String forename, String surname) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
    }*/

   /* public Users(Integer userID) {this.userID = userID;}

    public Integer getUserID() {
        return userID;
    }
*/
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

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

    public Integer getUserID() { return userID; }

    public void setUserID(Integer userID) { this.userID = userID; }
}
