package com.example.java_pandas.demostudentman.dto;

import com.example.java_pandas.demostudentman.entity.ContactInfo;

public class NewsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String date;
    private ContactInfo contactInfo;
    private AttachmentWithNewsResponseDto attachmentWithNewsResponseDto;
}
