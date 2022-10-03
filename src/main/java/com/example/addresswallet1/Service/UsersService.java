package com.example.addresswallet1.Service;

import com.example.addresswallet1.DAO.UsersDAO;
import com.example.addresswallet1.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersDAO usersdao;

    @Autowired
    public UsersService(@Qualifier("mysqlUser") UsersDAO usersdao) {
        this.usersdao = usersdao;
    }

    public Optional<Users> getUserByID(int userID) {
        return usersdao.getUserByID(userID);
    }

    public int createUser(Users user) {
        return usersdao.createUser(user);

    }

    public int updateUserByID(int userID, Users user) {
        return usersdao.updateUserByID(userID, user);
    }

    public int deleteUserByID(int userID) {
        return usersdao.deleteUserByID(userID);
    }

    public Optional<Users> getUserByUsername(String username) { return usersdao.getUserByUsername(username); }


}
