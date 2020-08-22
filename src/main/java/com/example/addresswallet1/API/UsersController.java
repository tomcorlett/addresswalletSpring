package com.example.addresswallet1.API;

import com.example.addresswallet1.Model.Users;
import com.example.addresswallet1.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/users")
@RestController
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "{userID}")
    public Users getUser(@PathVariable("userID") int userID) {
        return usersService.getUserByID(userID).orElse(null); //TODO: why is this not throwing an error anymore? custom error message
    }

    @PostMapping
    public void createUser(@RequestBody Users user) {
        usersService.createUser(user);
    }

    @PutMapping(path = "{userID}")
    public void updateUserByID(@PathVariable("userID") int userID, @RequestBody Users user) {
        usersService.updateUserByID(userID, user);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUserByID(@PathVariable("userID") int userID) {
        usersService.deleteUserByID(userID);
    }
}
