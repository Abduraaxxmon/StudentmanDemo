package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.dto.NewsResponseDto;
import com.example.java_pandas.demostudentman.service.AllNewsWithAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private AllNewsWithAttachmentService service;
    @GetMapping("/get-news")
    public ResponseEntity<List<NewsResponseDto>> getNews() {
        return null;
    }
}

