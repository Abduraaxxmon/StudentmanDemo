package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.dto.UserRegisterDto;
import com.example.java_pandas.demostudentman.mapper.UserMapper;
import com.example.java_pandas.demostudentman.repository.UserRepository;
import com.example.java_pandas.demostudentman.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public ResponseEntity<UserRegisterDto> register(UserRegisterDto user) {
        return ResponseEntity
                .ok(mapper
                        .toDto(userRepository
                                .save(mapper.toEntity(user))));
    }

    @Override
    public ResponseEntity<UserRegisterDto> login(UserRegisterDto user) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterDto> updateUserInfo(UserRegisterDto user) {
        return null;
    }
}
