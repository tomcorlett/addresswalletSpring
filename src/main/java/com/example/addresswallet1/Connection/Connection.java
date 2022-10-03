package com.example.addresswallet1.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

    /*public static void main(String[] args) {
        java.sql.Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            com.example.addresswallet1.Connection.Connection getConnection = new com.example.addresswallet1.Connection.Connection();
            dbCon = getConnection.getConnection();
            stmt = dbCon.createStatement();
            rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {if (dbCon != null) {dbCon.close();}} catch (Exception e) {}
            try {if (stmt != null) {stmt.close();}} catch (Exception e) {}
            try {if (rs != null) {rs.close();}} catch (Exception e) {}
        }
    }*/

    public java.sql.Connection getConnection() {
        java.sql.Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addresswallet_users?serverTimezone=GMT","root","password");
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }


}


