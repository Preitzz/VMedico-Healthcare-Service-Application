package com.vmedico.medapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vmedico.medapp.model.User;
import com.vmedico.medapp.repository.UserRepository;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

     
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), 
                user.getPassword(),
                new ArrayList<>() // This should be replaced with actual roles or authorities
        );
    }
}
