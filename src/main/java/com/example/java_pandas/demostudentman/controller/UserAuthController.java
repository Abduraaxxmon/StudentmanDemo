package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import com.example.java_pandas.demostudentman.dto.RegisterRequest;
import com.example.java_pandas.demostudentman.entity.User;
import com.example.java_pandas.demostudentman.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {
        return userService.loginUser(user);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest user) {
        return userService.registerUser(user);
    }
    @PostMapping("/skip")
    public ResponseEntity<String> skip(){
        RegisterRequest user = new RegisterRequest();
        user.setEmail(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        return userService.registerUser(user);
    }
}
