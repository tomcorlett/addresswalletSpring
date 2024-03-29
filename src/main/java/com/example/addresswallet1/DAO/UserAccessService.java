package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.Users;
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
                String password = rs.getString("password");
                userToReturn = Optional.of(new Users(username, forename, surname, password));
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
                userToReturn = Optional.of(new Users(username, forename, surname, password));
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
        System.out.println("Now in UserAccessService.createUser()");
        String username = user.getUsername();
        String forename = user.getForename();
        String surname = user.getSurname();
        String password = user.getPassword();
        System.out.println("username = " + username + ", forename = " + forename + ", surname = " + surname + ", password = " + password);

        java.sql.Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int userIDToReturn = -1;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.prepareStatement("insert into user (username, forename, surname, password) " +
                    "values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setString(4, password);
            int success = stmt.executeUpdate();
            if (success == 1) {
                rs = stmt.getGeneratedKeys();
                System.out.println("success");
                if (rs.next()) {
                    userIDToReturn = rs.getInt(1);
                    System.out.println("userIdToReturn = " + userIDToReturn);
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
