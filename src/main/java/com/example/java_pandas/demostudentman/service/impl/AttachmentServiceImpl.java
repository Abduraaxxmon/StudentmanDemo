package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.entity.Attachment;
import com.example.java_pandas.demostudentman.entity.New;
import com.example.java_pandas.demostudentman.repository.AttachmentRepository;
import com.example.java_pandas.demostudentman.repository.NewsRepository;
import com.example.java_pandas.demostudentman.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final NewsRepository newsRepository;
    @Override
    public ResponseEntity<List<Long>> uploadAttachment(MultipartHttpServletRequest multipart, Long id) {
        Optional<New> aNew = newsRepository.findById(id);
        if (aNew.isPresent()) {
            New news = aNew.get();
            List<Long> attachmentIds = new ArrayList<>();

            File folder = new File("E:\\Attachment");
            if (!folder.exists()) {
                if (!folder.mkdirs()) { // Create directories if they don't exist
                    throw new RuntimeException("Failed to create directory: " + folder.getAbsolutePath());
                }
            }

            Iterator<String> listFileNames = multipart.getFileNames();
            while (listFileNames.hasNext()) {
                String fileNameKey = listFileNames.next();
                MultipartFile file = multipart.getFile(fileNameKey);
                if (file != null) {
                    String ext = getExtension(file.getOriginalFilename());
                    String newFileName = UUID.randomUUID() + ext; // Unique filename with extension
                    File fileToSave = new File(folder, newFileName);

                    try {
                        // Save the uploaded file
                        file.transferTo(fileToSave);
                        Attachment attachment = new Attachment();
                        attachment.setNewsAttachment(news);
                        attachment.setExtension(ext);
                        attachment.setContentType(file.getContentType());
                        attachment.setSize(file.getSize());
                        attachment.setFilename(file.getOriginalFilename());
                        attachment.setFilePath(fileToSave.getAbsolutePath());
                        attachment = attachmentRepository.save(attachment);
                        attachmentIds.add(attachment.getId());
                    } catch (IOException e) {
                        e.printStackTrace(); // Log the stack trace for debugging
                        return ResponseEntity.notFound().build();
                    }
                }
            }
            log.info(attachmentIds.toString());
            return ResponseEntity.ok(attachmentIds);
        }

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Resource> loadAttachment(Long id) throws FileNotFoundException {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);

        if (attachmentOptional.isPresent()) {
            Attachment attachment = attachmentOptional.get();
            File file = new File(attachment.getFilePath());
            if (file.exists()) {
                Resource resource = new InputStreamResource(new FileInputStream(file));
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, attachment.getContentType())
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "inline; filename=\"" + attachment.getFilename() + "\"")
                        .body(resource);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteAttachment(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if (attachment.isPresent()) {
            attachmentRepository.delete(attachment.get());
        }
        return ResponseEntity.noContent().build();
    }

    private String getExtension(String originalFilename) {
        if (originalFilename == null || originalFilename.isEmpty()) {
            return "";
        }
        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }
}
