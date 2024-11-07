package com.example.java_pandas.demostudentman.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileNotFoundException;
import java.util.List;

public interface AttachmentService {
    ResponseEntity<List<Long>> uploadAttachment(MultipartHttpServletRequest file, Long id);
    ResponseEntity<Resource> loadAttachment(Long id) throws FileNotFoundException;
    ResponseEntity deleteAttachment(Long id);


}
