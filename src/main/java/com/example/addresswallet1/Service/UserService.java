package com.example.addresswallet1.Service;

import com.example.addresswallet1.DAO.UserDAO;
import com.example.addresswallet1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("fakeDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int addUser(User user) {
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public Optional<User> getUserByID(UUID id) {
        return userDAO.selectUserByID(id);
    };

    public int deleteUserByID(UUID id) {
        return userDAO.deleteUserByID(id);
    }

    public int updateUserByID(UUID id, User user) {
        return userDAO.updateUserByID(id, user);
    }
}
