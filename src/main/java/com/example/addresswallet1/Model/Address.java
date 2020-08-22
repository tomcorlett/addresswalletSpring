package com.example.addresswallet1.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private Integer addressID;
    private int userID;
    private User user;
    private AddressType addressType;
    private String addressDescription;
    private String addressNumber;
    private String streetName;
    private String town;
    private String city;
    private String county;
    private String country;
    private String postcode;

    public Address(
            @JsonProperty("addressid") Integer addressID,
            @JsonProperty("userid") int userID,
            @JsonProperty("addresstype") AddressType addressType,
            @JsonProperty("addressnumber") String addressNumber,
            @JsonProperty("streetname") String streetName,
            @JsonProperty("town") String town,
            @JsonProperty("city") String city,
            @JsonProperty("county") String county,
            @JsonProperty("country") String country,
            @JsonProperty("postcode") String postcode) {
        this.addressID = addressID;
        this.userID = userID;
        this.addressType = addressType;
        this.addressNumber = addressNumber;
        this.streetName = streetName;
        this.town = town;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        addressID = addressID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    /*public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }*/

    public int getAddressTypeID() {
        return addressType.getID();
    }

    public void setAddressTypeID(int ID) {
        addressType.setID(ID);
    }

    public String getAddressDescription() {
        return addressType.getName();
    }

    public void setAddressDescription(String addressDescription) {
        this.addressType.setName(addressDescription);
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
