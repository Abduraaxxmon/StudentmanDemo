package com.example.java_pandas.demostudentman.service.impl;

import com.example.java_pandas.demostudentman.dto.AttachmentWithNewsResponseDto;
import com.example.java_pandas.demostudentman.entity.Attachment;
import com.example.java_pandas.demostudentman.entity.New;
import com.example.java_pandas.demostudentman.repository.AttachmentRepository;
import com.example.java_pandas.demostudentman.repository.NewsRepository;
import com.example.java_pandas.demostudentman.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final NewsRepository newsRepository;

    @Override
    public ResponseEntity<List<Long>> uploadAttachment(MultipartFile file,Long id) {

        Optional<New> aNew= newsRepository.findById(id);
        if(aNew.isPresent()){
            New news = aNew.get();
            List<Long> attachmentIds = new ArrayList<>();

            File folder = new File("D:\\Attachment");
            if (!folder.exists()) {
                folder.mkdir();
                for(MultipartFile multipartFile : file) {

                    String fileName = UUID.randomUUID().toString();
                    String ext = getExtantion(multipartFile.getOriginalFilename());

                    File fileToSave = new File("D:\\Attachment\\" + fileName+ ext);

                    try{
                        multipartFile.transferTo(fileToSave);
                        Attachment attachment = new Attachment();
                        attachment.setNewsAttachment(news);
                        attachment.setExtension(ext);
                        attachment.setSize(multipartFile.getSize());
                        attachment.setFilename(multipartFile.getOriginalFilename());
                        attachment.setFilePath(fileToSave.getAbsolutePath());
                        attachmentRepository.save(attachment);
                        attachmentIds.add(attachment.getId());

                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            return ResponseEntity.ok(attachmentIds);
            }
        return ResponseEntity.noContent().build();
        }





    @Override
    public ResponseEntity<Resource> loadAttachment(Long id) throws FileNotFoundException {
        New news = newsRepository.getReferenceById(id);

        Optional<Attachment> attachmentOptional= Optional
                .ofNullable(attachmentRepository.findByNewsAttachment(news));

        if(attachmentOptional.isPresent()) {
            Attachment attachment = attachmentOptional.get();
            File file = new File( attachment.getFilename());
            if(file.exists()) {
                Resource resource = new InputStreamResource(new FileInputStream(file));

                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "inline; filename=\""+attachment.getFilename()+"\""+attachment.getExtension())
                        .body(resource);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity deleteAttachment(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if(attachment.isPresent()) {
            attachmentRepository.delete(attachment.get());
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public AttachmentWithNewsResponseDto findAttachmentById(Long id) {
        return null;
    }
    private String getExtantion(String originalFilename) {
        if(originalFilename == null || originalFilename.isEmpty()){
            return "";
        }
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        return ext;
    }
}
