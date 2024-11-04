package com.example.java_pandas.demostudentman.controller;

import com.example.java_pandas.demostudentman.service.AttachmentService;
import lombok.AllArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/attachment")
@AllArgsConstructor
public class AttachmentController {
    private AttachmentService attachmentService;

    @PostMapping("upload-attachment")
    public ResponseEntity<List<Long>> uploadAttachment(@RequestParam("file") MultipartFile file, @RequestParam Long id) {
        return attachmentService.uploadAttachment(file,id);
    }
    @GetMapping("get-attachment")
    public ResponseEntity<Resource> getAttachment(@RequestParam("id") Long id) throws FileNotFoundException {
        return attachmentService.loadAttachment(id);
    }
}
