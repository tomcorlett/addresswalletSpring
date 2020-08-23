package com.example.addresswallet1.API;

import com.example.addresswallet1.Model.User;
import com.example.addresswallet1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);
    }



    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public User getUserByID(@PathVariable("id") UUID id) {
        return userService.getUserByID(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateUserByID(@Valid @NonNull @RequestBody User user, @PathVariable("id") UUID id) {
        userService.updateUserByID(id, user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserByID(@PathVariable("id") UUID id) {
        userService.deleteUserByID(id);
    }
}
