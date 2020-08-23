package com.example.addresswallet1.API;

import com.example.addresswallet1.Model.Users;
import com.example.addresswallet1.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/v1/users")
@RestController
public class UsersController {
    private final UsersService usersService;

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "{userID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users getUser(@PathVariable("userID") int userID) {
        return usersService.getUserByID(userID).orElse(null); //TODO: why is this not throwing an error anymore? custom error message
    }

    @PostMapping
    public int createUser(@RequestBody Users user) {
        return usersService.createUser(user);
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
