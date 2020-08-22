package com.example.addresswallet1.Service;

import com.example.addresswallet1.DAO.AddressDAO;
import com.example.addresswallet1.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressDAO addressDAO;

    @Autowired
    public AddressService(@Qualifier("mysqlAddress") AddressDAO addressDAO) {this.addressDAO = addressDAO;}

    public int addAddress(Address address) {
        return addressDAO.insertAddress(address);
    }

    public int deleteAddressByID(int id) { return addressDAO.deleteAddressByID(id); }

    public Optional<Address> getAddressByID(int ID) { return addressDAO.getAddressByID(ID); }

    public List<Address> getAllAddressesOfUserByID(int userID) { return addressDAO.getAllAddressesOfUserByID(userID); }

    public int updateAddressByID(int addressID, Address address) { return addressDAO.updateAddressByID(addressID, address); }

}
