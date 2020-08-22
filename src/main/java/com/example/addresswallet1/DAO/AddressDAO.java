package com.example.addresswallet1.DAO;

import com.example.addresswallet1.Model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDAO {
    int insertAddress(Address address);

    Optional<Address> getAddressByID(int addressID);

    List<Address> getAllAddressesOfUserByID(int userID);

    int deleteAddressByID(int addressID);

    int updateAddressByID(int addressID, Address address);
}
