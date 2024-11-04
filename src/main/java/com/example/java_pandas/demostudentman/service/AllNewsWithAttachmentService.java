package com.example.java_pandas.demostudentman.service;

import com.example.java_pandas.demostudentman.dto.NewsResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllNewsWithAttachmentService {
    public ResponseEntity<List<NewsResponseDto>> getAllNewsWithAttachment();

}
