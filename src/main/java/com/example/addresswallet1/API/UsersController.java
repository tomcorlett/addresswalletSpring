package com.example.addresswallet1.API;

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
        //TODO: Should we use a factory here to generate responsecode?
        //how could we make this generic?
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        switch (responseCode) {
            case -1: //TODO: change this accordingly when the dao is updated to reflect database errors
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; //TODO: actually, I don't think we should be using this code, or http status codes in general. Custom codes implemented on the front end and back end might work better
                break;
            default:
                httpStatus = HttpStatus.OK;
                break;
        }
        return new ResponseEntity<String>(responseCode + "", httpStatus);
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
