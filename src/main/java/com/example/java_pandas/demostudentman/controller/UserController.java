package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.dto.UserRegisterDto;
import com.example.java_pandas.demostudentman.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping
    public ResponseEntity<UserRegisterDto> userRegistger(@RequestBody UserRegisterDto dto){
        return userService.register(dto);
    }
}
