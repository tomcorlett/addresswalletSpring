package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.Users;

import java.util.Optional;

public interface UsersDAO {

    Optional<Users> getUserByID(int userID);

    int createUser(Users user);

    int deleteUserByID(int userID);

    int updateUserByID(int userID, Users user);

    Optional<Users> getUserByUsername(String username);
}
