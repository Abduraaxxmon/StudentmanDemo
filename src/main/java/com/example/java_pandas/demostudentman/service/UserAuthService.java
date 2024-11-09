package com.example.java_pandas.demostudentman.service;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import com.example.java_pandas.demostudentman.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface UserAuthService {
    public ResponseEntity<String> registerUser(RegisterRequest user);
    public ResponseEntity<String> loginUser(LoginRequest user);


}
