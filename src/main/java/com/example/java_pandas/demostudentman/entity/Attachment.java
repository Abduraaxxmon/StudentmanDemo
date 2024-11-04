package com.example.java_pandas.demostudentman.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private New newsAttachment;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Long size;



}
