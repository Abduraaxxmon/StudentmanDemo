package com.example.java_pandas.demostudentman.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="contact_info")
@Entity
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="news_id",nullable = false,unique = true)
    private New news;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String webside;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;


}
