package com.example.addresswallet1.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressType {
    private int ID;
    private String name;

    /*AddressType(@JsonProperty("id") int ID) {
        this.ID = ID;
        switch (ID) {
            case 0:
                name = "Home";
                break;
            case 1:
                name = "Work";
                break;
            case 2:
                name = "Billing";
                break;
            case 3:
                name = "Custom";
                break;
        }
    }*/

    public AddressType(@JsonProperty("name") String name) {
        this.name = getFormattedName(name);
        switch (this.name) {
            case "Home":
                ID = 0;
                break;
            case "Work":
                ID = 1;
                break;
            case "Billing":
                ID = 2;
                break;
            default:
                ID = 3;
                break;
        }
    }

    /*AddressType(@JsonProperty("id") int ID, @JsonProperty("name") String name) {
        this.ID = ID;
        this.name = getName(name);
    }*/

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getFormattedName(String name) {
        if (name == null) return "";
        if (name.length() < 2) return name.toUpperCase();
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
