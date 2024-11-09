package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("email")
    public ResponseEntity<String> email() {
        return userService.getEmail();
    }

}
