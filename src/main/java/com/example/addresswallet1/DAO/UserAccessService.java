package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.User;
import com.example.addresswallet1.Model.Users;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

@Repository("mysqlUser")
public class UserAccessService implements UsersDAO {
    @Override
    public Optional<Users> getUserByID(int userID) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Optional<Users> userToReturn = Optional.empty();
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("select * from user where userid = ?");
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                userToReturn = Optional.of(new Users(userID, username, forename, surname));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return userToReturn;
    }

    @Override
    public Optional<Users> getUserByUsername(String username) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Optional<Users> userToReturn = Optional.empty();
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("select * from user where username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("userid");
                String password = rs.getString("password");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                boolean isEnabled = rs.getBoolean("isEnabled");
                userToReturn = Optional.of(new Users(userID, username, forename, surname));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }

        return userToReturn;
    }

    @Override
    public int createUser(Users user) {
        String username = user.getUsername();
        String forename = user.getForename();
        String surname = user.getSurname();

        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int userIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("insert into user (username, forename, surname) " +
                    "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            int success = stmt.executeUpdate();
            if (success == 1) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    userIDToReturn = rs.getInt(1);
                }
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

    @Override
    public int deleteUserByID(int userID) {
        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int userIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("delete from user where userid = ?");
            stmt.setInt(1, userID);
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

    @Override
    public int updateUserByID(int userID, Users user) {
        String username = user.getUsername();
        String forename = user.getForename();
        String surname = user.getSurname();

        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int userIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("update user set username = ?, forename = ?, surname = ? " +
                    "where userid = ?");
            stmt.setString(1, username);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setInt(4, userID);
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
}
