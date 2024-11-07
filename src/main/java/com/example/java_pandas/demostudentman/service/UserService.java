package com.example.java_pandas.demostudentman.service;

import com.example.java_pandas.demostudentman.dto.UserRegisterDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<UserRegisterDto> register(UserRegisterDto user);
    public ResponseEntity<UserRegisterDto> login(UserRegisterDto user);
    public ResponseEntity<UserRegisterDto> updateUserInfo(UserRegisterDto user);


}
