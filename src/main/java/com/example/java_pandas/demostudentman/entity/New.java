package com.example.java_pandas.demostudentman.entity;

import com.example.java_pandas.demostudentman.status.Event;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String content;
    private Date uploaded_at;
    private Date edited_at;
    @Enumerated(EnumType.STRING)
    private Event status;
}
