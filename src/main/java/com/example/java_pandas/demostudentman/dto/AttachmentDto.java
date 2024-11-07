package com.example.java_pandas.demostudentman.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachmentDto {

    private String fileName;
    private String contentType;
    private String filePath;
    private Long fileSize;
    private String uri;
}
