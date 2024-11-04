package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.dto.NewsResponseDto;
import com.example.java_pandas.demostudentman.entity.New;
import com.example.java_pandas.demostudentman.repository.AttachmentRepository;
import com.example.java_pandas.demostudentman.repository.NewsRepository;
import com.example.java_pandas.demostudentman.service.AllNewsWithAttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class AllNewsWithAttachment implements AllNewsWithAttachmentService {
    private final NewsRepository newsRepository;
    private final AttachmentRepository attachmentRepository;
    @Override
    public ResponseEntity<List<NewsResponseDto>> getAllNewsWithAttachment() {
        New news = newsRepository.getAll();
    }
}
