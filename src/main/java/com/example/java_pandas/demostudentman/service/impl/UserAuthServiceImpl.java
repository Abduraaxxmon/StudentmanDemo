package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import com.example.java_pandas.demostudentman.dto.RegisterRequest;
import com.example.java_pandas.demostudentman.entity.User;
import com.example.java_pandas.demostudentman.repository.UserRepository;
import com.example.java_pandas.demostudentman.service.UserAuthService;
import com.example.java_pandas.demostudentman.service.securService.JwtService;
import com.example.java_pandas.demostudentman.status.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<String> registerUser(RegisterRequest registerRequest) {
        User user = new User();
        Optional<User> checking = userRepository.findByEmail(registerRequest.getEmail());
        if (!checking.isPresent()) {
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setRole(Role.valueOf("ROLE_USER"));
            userRepository.save(user);
            return ResponseEntity.ok().body(jwtService.generateToken(user.getEmail()));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User already exists");
        }
    }
    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {
        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken(loginRequest.getEmail());

        return ResponseEntity.ok().body(token);
    }catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
