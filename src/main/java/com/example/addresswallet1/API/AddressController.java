package com.example.addresswallet1.API;

import com.example.addresswallet1.Model.Address;
import com.example.addresswallet1.Model.Users;
import com.example.addresswallet1.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/address")
@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @GetMapping(path = "{id}")
    public Address getAddressByID(@PathVariable("id") int ID) {
        return addressService.getAddressByID(ID)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAddressByID(@PathVariable("id") int ID) { addressService.deleteAddressByID(ID); }

    @GetMapping(path = "user/{id}")
    public List<Address> getAllAddressesOfUserByID(@PathVariable("id") int userID) { return addressService.getAllAddressesOfUserByID(userID); }

    @PutMapping(path = "{id}")
    public int updateAddressByID(@PathVariable("id") int addressID, @RequestBody Address address) {
        return addressService.updateAddressByID(addressID, address);
    }
}
