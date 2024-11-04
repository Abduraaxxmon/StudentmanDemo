package com.example.java_pandas.demostudentman.dto;

import java.io.Serializable;

public class AttachmentWithNewsResponseDto implements Serializable {
    private Long id;
    private String fileName;
    private String contentType;
    private String filePath;
    private Long fileSize;
    private String uri;
}
