package com.example.addresswallet1.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Users implements UserDetails {
    private String username;
    private String password;
    private String forename;
    private String surname;
    private Integer userID;

    /*public Users(@JsonProperty("username") String username, @JsonProperty("forename") String forename, @JsonProperty("surname") String surname) {
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        userID = null;
    }*/

    public Users(@JsonProperty("username") String username, @JsonProperty("forename") String forename, @JsonProperty("surname") String surname, @JsonProperty("password") String password) {
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //may need to be an empty list returned
        return null;
    }

    public String getPassword() {
        System.out.println("Now in Users object, tryna get that password");
        System.out.println("password = " + password);
        return this.password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
