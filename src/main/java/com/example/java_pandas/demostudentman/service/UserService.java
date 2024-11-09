package com.example.java_pandas.demostudentman.service.impl;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> login(String username, String passwo);
}
