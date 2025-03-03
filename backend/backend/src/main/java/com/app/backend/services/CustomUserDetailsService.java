package com.app.backend.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (!"jordyvega15@gmail.com".equals(email)) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new User(email, new BCryptPasswordEncoder().encode("123456"), Collections.emptyList());
    }
}

