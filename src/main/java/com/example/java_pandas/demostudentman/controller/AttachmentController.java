package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.service.AttachmentService;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/attachment")

public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("upload-attachment")
    public ResponseEntity<List<Long>> uploadAttachment( MultipartHttpServletRequest file, @RequestParam Long id) {
        return attachmentService.uploadAttachment(file,id);
    }
    @GetMapping("get-attachment")
    public ResponseEntity<Resource> getAttachment(@RequestParam("id") Long id) throws FileNotFoundException {
        return attachmentService.loadAttachment(id);
    }
}
