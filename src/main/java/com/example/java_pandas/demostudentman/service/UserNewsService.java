package com.example.java_pandas.demostudentman.service;

import com.example.java_pandas.demostudentman.dto.UserNewsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserNewsService {
    public Set<UserNewsDto> getUserNews(Long id);

}
