package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Connection.Connection;
import com.example.addresswallet1.Model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDAO")
public class FakeUserAccessService implements UserDAO {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUsername()));
        return 1;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserByID(UUID id) {
        return DB.stream()
                .filter(user -> user.getUserID().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserByID(UUID id) {
        Optional<User> userMaybe = selectUserByID(id);
        if (!userMaybe.isPresent()) {
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserByID(UUID id, User update) {
        return selectUserByID(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.indexOf(user);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(id, update.getUsername()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
