package com.example.addresswallet1.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Users implements UserDetails {
    private final Integer userID;
    private String username;
    private String password;
    private String forename;
    private String surname;
    private boolean isEnabled;

    public Users(Integer userID, String username, String forename, String surname) {
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
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

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
}
