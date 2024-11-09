package com.example.java_pandas.demostudentman.service;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> getEmail();
}
