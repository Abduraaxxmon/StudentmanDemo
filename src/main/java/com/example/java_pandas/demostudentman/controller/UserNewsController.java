package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.dto.UserNewsDto;
import com.example.java_pandas.demostudentman.service.UserNewsService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")

public class UserNewsController {
    @Autowired
    private  UserNewsService service;


    @GetMapping("/get-news")
    public Set<UserNewsDto> getNews() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return service.getUserNews(authentication.getName());
    }
}

