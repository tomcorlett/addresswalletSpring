package com.example.addresswallet1.API;

import com.example.addresswallet1.Model.API.APIResponse;
import com.example.addresswallet1.Model.Database.DatabaseError;
import com.example.addresswallet1.Model.Database.DatabaseErrorFactory;
import com.example.addresswallet1.Model.Users;
import com.example.addresswallet1.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        System.out.println("in UsersController.createUser()");
        int responseCode = usersService.createUser(user);
        //TODO:we need to check that the username does not already exist (email)

        //TODO: Should we use a factory here to generate responsecode?
        //how could we make this generic?
        //TODO: eventually, dao will return databaseError object, and we can just pass that in to getAPIErrorFromDatabaseError
        APIResponse apiResponse = DatabaseErrorFactory.getInstance().getAPIResponseFromDatabaseError(new DatabaseError(responseCode, ""));
        HttpStatus httpStatus = apiResponse.getHttpResponseCode();
        String errorDescription = apiResponse.getErrorDescription();
        return new ResponseEntity<String>(errorDescription, httpStatus);
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
