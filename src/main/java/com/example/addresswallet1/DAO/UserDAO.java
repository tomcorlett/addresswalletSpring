package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDAO {

    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> getAllUsers();

    Optional<User> selectUserByID(UUID id);

    int deleteUserByID(UUID id);

    int updateUserByID(UUID id, User user);
}
