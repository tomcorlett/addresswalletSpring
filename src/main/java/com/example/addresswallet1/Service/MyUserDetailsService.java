package com.example.addresswallet1.Service;

import com.example.addresswallet1.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Now in MyUserDetailsService.loadUserByUsername");
        System.out.println("username = " + username);

        Users user = usersService.getUserByUsername(username).orElse(null);
        System.out.println("User == null ? " + (user == null));
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return user;
    }
}
