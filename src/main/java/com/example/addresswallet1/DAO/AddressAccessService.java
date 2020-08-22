package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.Address;
import com.example.addresswallet1.Model.AddressType;
import com.example.addresswallet1.Model.Users;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mysqlAddress")
public class AddressAccessService implements AddressDAO {

    @Override
    public int insertAddress(Address address) {
        int userID = address.getUserID();
        int addresstype = address.getAddressTypeID();
        String addressDescription = address.getAddressDescription();
        String addressNumber = address.getAddressNumber();
        String streetName = address.getStreetName();
        String town = address.getTown();
        String city = address.getCity();
        String county = address.getCounty();
        String country = address.getCountry();
        String postcode = address.getPostcode();

        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int addressIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("insert into address (userid, addresstype, addressdescription, number, " +
                    "streetname, town, city, county, country, postcode)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userID);
            stmt.setInt(2, addresstype);
            stmt.setString(3, addressDescription);
            stmt.setString(4, addressNumber);
            stmt.setString(5, streetName);
            stmt.setString(6, town);
            stmt.setString(7, city);
            stmt.setString(8, county);
            stmt.setString(9, country);
            stmt.setString(10, postcode);

            int success = stmt.executeUpdate();
            if (success == 1) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    addressIDToReturn = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return addressIDToReturn;
    }

    @Override
    public Optional<Address> getAddressByID(int addressID) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Optional<Address> addressToReturn = Optional.empty();
        Address address = null;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("select * from address where addressid = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addressID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                address = new Address(
                        addressID,
                        rs.getInt("userid"),
                        new AddressType(rs.getString("addressdescription")),
                        rs.getString("number"),
                        rs.getString("streetname"),
                        rs.getString("town"),
                        rs.getString("city"),
                        rs.getString("county"),
                        rs.getString("country"),
                        rs.getString("postcode")
                );
                addressToReturn = Optional.of(address);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return addressToReturn;
    }

    @Override
    public List<Address> getAllAddressesOfUserByID(int userID) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Address> addressesToReturn = new ArrayList<>();
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("select * from address where userid = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Address address = new Address(
                        rs.getInt("addressid"),
                        userID,
                        new AddressType(rs.getString("addressdescription")),
                        rs.getString("number"),
                        rs.getString("streetname"),
                        rs.getString("town"),
                        rs.getString("city"),
                        rs.getString("county"),
                        rs.getString("country"),
                        rs.getString("postcode")
                );
                addressesToReturn.add(address);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return addressesToReturn;
    }

    @Override
    public int deleteAddressByID(int addressID) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int userIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("delete from address where addressid = ?");
            stmt.setInt(1, addressID);
            int success = stmt.executeUpdate();
            if (success == 1) {
                userIDToReturn = 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return userIDToReturn;
    }

    //TODO: this shouldn't be setting the userid or the addressid
    //docs: error codes:
    //-1: nothing updated - address not found or connection issue etc.
    //1: success - exactly one address was updated successfully
    @Override
    public int updateAddressByID(int addressID, Address newAddress) {
        int userID = newAddress.getUserID();
        int addresstype = newAddress.getAddressTypeID();
        String addressDescription = newAddress.getAddressDescription();
        String addressNumber = newAddress.getAddressNumber();
        String streetName = newAddress.getStreetName();
        String town = newAddress.getTown();
        String city = newAddress.getCity();
        String county = newAddress.getCounty();
        String country = newAddress.getCountry();
        String postcode = newAddress.getPostcode();

        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int updateSuccessful = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("update address set userid = ?," +
                    "addresstype = ?, " +
                    "addressdescription = ?, " +
                    "number = ?, " +
                    "streetname = ?, " +
                    "town = ?, " +
                    "city = ?, " +
                    "county = ?, " +
                    "country = ?, " +
                    "postcode = ? " +
                    "where addressid = ?");
            stmt.setInt(1, userID);
            stmt.setInt(2, addresstype);
            stmt.setString(3, addressDescription);
            stmt.setString(4, addressNumber);
            stmt.setString(5, streetName);
            stmt.setString(6, town);
            stmt.setString(7, city);
            stmt.setString(8, county);
            stmt.setString(9, country);
            stmt.setString(10, postcode);
            stmt.setInt(11, addressID);

            int success = stmt.executeUpdate();
            if (success == 1) {
                updateSuccessful = 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return updateSuccessful;
    }
}
