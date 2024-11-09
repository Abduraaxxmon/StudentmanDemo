package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import com.example.java_pandas.demostudentman.mapper.UserMapper;
import com.example.java_pandas.demostudentman.repository.UserRepository;
import com.example.java_pandas.demostudentman.service.UserService;
import com.example.java_pandas.demostudentman.service.securService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private JwtService jwtService;
    @Override
    public ResponseEntity<String> getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return ResponseEntity
                .ok().body(username);
    }
    // have to write crud for email
}
